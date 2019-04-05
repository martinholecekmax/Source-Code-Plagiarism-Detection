@Service
public class DefaultPageLayoutService implements PageLayoutService {
    private final PageLayoutRepository pageLayoutRepository;
    @Autowired
    public DefaultPageLayoutService(PageLayoutRepository pageLayoutRepository) {
        this.pageLayoutRepository = pageLayoutRepository;
    }
    @Override
    public PageLayout getPageLayoutByCode(String code) {
        return pageLayoutRepository.getByPageLayoutCode(code);
    }
    @Override
    public List<PageLayout> getAll() {
        return pageLayoutRepository.getAll();
    }
    @Override
    public List<PageLayout> getAllUserSelectable() {
        return pageLayoutRepository.getAllUserSelectable();
    }
}