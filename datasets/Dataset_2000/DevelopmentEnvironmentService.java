@Service
@Environment(Environment.DEVELOPMENT)
public class DevelopmentEnvironmentService implements EnvironmentService {
    public String getEnvironment() {
        return Environment.DEVELOPMENT;
    }
}