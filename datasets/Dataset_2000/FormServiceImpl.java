public class FormServiceImpl extends BaseOpenmrsService implements FormService {
    private FormDAO dao;
    public void setDao(FormDAO dao) {
        this.dao = dao;
    }
    @Transactional(readOnly = true)
    public Form getForm(Integer id) {
        return dao.getForm(id);
    }
    @Transactional
    public Form saveForm(Form fid) {
        return dao.saveForm(fid);
    }
}