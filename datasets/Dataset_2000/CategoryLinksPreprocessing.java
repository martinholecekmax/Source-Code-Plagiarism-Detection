public class CategoryLinksPreprocessing {
    public static void process(File input, File output) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(output);
        int processedCount = 0;
        int ignored = 0;
                        out.println("page_id|cl_to|cl_type");
        Set<String> badCategories = new HashSet<String>();
        for (List<String> data : CsvUtils.readCsvIgnoreFirstLine(input, '|', '\'')) {
            if (processedCount++ % 1000000 == 0) {
                System.out.println("Processed count: " + processedCount);
            }
            if (data.size() != 7) {
                throw new RuntimeException(data.toString());
            }
            if (data.get(3).startsWith("'2012")) {
                continue;
            }
            long pageId = Long.parseLong(data.get(0));
            String categoryTitle = data.get(1);
            categoryTitle = categoryTitle.substring(1, categoryTitle.length() - 1);
            if (!Categories.RAW.containsName(categoryTitle)) {
                if (!badCategories.contains(categoryTitle)) {
                    badCategories.add(categoryTitle);
                }
                ignored++;
            } else {
                out.println(
                        pageId + "|" + Categories.RAW.getByName(categoryTitle).id + "|" + data.get(6)
                );
            }
        }
        out.flush();
        System.out.println("Bad categories size " + badCategories.size());
        System.out.println("Ignored " + ignored);
    }
}