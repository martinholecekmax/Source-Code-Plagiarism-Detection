public abstract class ElementAdapterBase<Bean extends ElementBeanBase, Model extends BeanModelBase> extends
        AdapterBase<Bean, Model> {
    protected void postMarshal(Model model, Bean bean) {
        bean.setFilterHiddenAttributes(true);
    }
    ;
}