public class PropertyTableRenderer {
    public void renderTo(Iterable<PropertyDoc> properties, Element parent) {
        Document document = parent.getOwnerDocument();
                                                        Element thead = document.createElement("thead");
        parent.appendChild(thead);
        Element tr = document.createElement("tr");
        thead.appendChild(tr);
        Element td = document.createElement("td");
        tr.appendChild(td);
        td.appendChild(document.createTextNode("Property"));
        td = document.createElement("td");
        tr.appendChild(td);
        td.appendChild(document.createTextNode("Description"));
        for (PropertyDoc propDoc : properties) {
                                                            tr = document.createElement("tr");
            parent.appendChild(tr);
            td = document.createElement("td");
            tr.appendChild(td);
            Element link = document.createElement("link");
            td.appendChild(link);
            link.setAttribute("linkend", propDoc.getId());
            Element literal = document.createElement("literal");
            link.appendChild(literal);
            literal.appendChild(document.createTextNode(propDoc.getName()));
            td = document.createElement("td");
            tr.appendChild(td);
            if (propDoc.isDeprecated()) {
                Element caution = document.createElement("caution");
                td.appendChild(caution);
                caution.appendChild(document.createTextNode("Deprecated"));
            }
            if (propDoc.isIncubating()) {
                Element caution = document.createElement("caution");
                td.appendChild(caution);
                caution.appendChild(document.createTextNode("Incubating"));
            }
            td.appendChild(document.importNode(propDoc.getDescription(), true));
        }
    }
}