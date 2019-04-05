public class LaunchConfigurationComparator extends WorkbenchViewerComparator {
	
	private static Map fgCategories;
	
	public int category(Object element) {
		Map map = getCategories();
		if (element instanceof ILaunchConfiguration) {
			ILaunchConfiguration configuration = (ILaunchConfiguration) element;
			try {
				Integer i = (Integer) map.get(configuration.getType());
				if (i != null) {
					return i.intValue();
				}
			} catch (CoreException e) {
			}
		}
		return map.size();
	}
	
	private Map getCategories() {
		if (fgCategories == null) {
			fgCategories = new HashMap();
			List types = Arrays.asList(DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurationTypes());
			Collections.sort(types, new Comparator() {
				public int compare(Object o1, Object o2) {
					ILaunchConfigurationType t1 = (ILaunchConfigurationType) o1;
					ILaunchConfigurationType t2 = (ILaunchConfigurationType) o2;
					return t1.getName().compareTo(t2.getName());
				}
			});
			Iterator iterator = types.iterator();
			int i = 0;
			while (iterator.hasNext()) {
				fgCategories.put(iterator.next(), new Integer(i));
				i++;
			}
		}
		return fgCategories;
	}
}