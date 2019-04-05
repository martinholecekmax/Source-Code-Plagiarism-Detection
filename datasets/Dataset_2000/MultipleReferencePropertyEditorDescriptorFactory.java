public class MultipleReferencePropertyEditorDescriptorFactory implements IPropertyEditorDescriptorFactory {
	
	public IPropertyEditorDescriptor createEditorDescriptor(Node editorNode) {
		String identifier = "";
		String label = "";
		String tooltipText = "";
		int labelPosition = SWT.LEFT;
		ImageDescriptor imageDescriptor = null;
				NamedNodeMap attributes = editorNode.getAttributes();
		if(attributes != null) {
			for(int i = 0; i < attributes.getLength(); i++) {
				Node attribute = attributes.item(i);
				String nodeName = attribute.getNodeName();
				if("label".equals(nodeName)) {
					label = attribute.getNodeValue();
				} else if("labelPosition".equals(nodeName)) {
					labelPosition = Integer.parseInt(attribute.getNodeValue());
				} else if("id".equals(nodeName)) {
					identifier = attribute.getNodeValue();
				} else if("tooltip".equals(nodeName)) {
					tooltipText = attribute.getNodeValue();
				}
			}
		}
				NodeList children = editorNode.getChildNodes();
		for(int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if("icon".equals(child.getNodeName())) {
				NamedNodeMap iconAttributes = child.getAttributes();
				if(iconAttributes != null) {
										Node pluginIDNode = iconAttributes.getNamedItem("pluginID");
					Node pathNode = iconAttributes.getNamedItem("path");
					if(pluginIDNode != null && pathNode != null) {
						imageDescriptor = Activator.imageDescriptorFromPlugin(pluginIDNode.getNodeValue(), pathNode.getNodeValue());
					}
				}
			}
		}
		return new MultipleReferencePropertyEditorDescriptor(identifier, label, labelPosition, tooltipText, imageDescriptor);
	}
}