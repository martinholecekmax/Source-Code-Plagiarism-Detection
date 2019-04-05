public class WriteFile extends ColumnFixture {
    private static final Logger logger = LoggerFactory.getLogger(WriteFile.class);
	@Override
	public void doRows(Parse rows) {
		if(args.length != 1) {
			logger.error("No argument to WriteFile");
			throw new IllegalArgumentException("The WriteFile fixture requires an argument that is the filename to create");
		}
		PrintStream out = null;
		try {
			File f = new File(args[0]);
			logger.info("Creating file {}", f.getAbsolutePath());
			out = new PrintStream(f);
			Parse row = rows;
			while((row=row.more) != null) {
				Parse column = row.parts;
				do {
					out.println(column.text());
					right(column);
				} while((column = column.more) != null);
			}			
		} catch (IOException e) {
			logger.error("Error writing file", e);
			throw new RuntimeException(e);
		}
		finally {
			if(out != null) {
				Util.close(out);
			}
		}
	}
}