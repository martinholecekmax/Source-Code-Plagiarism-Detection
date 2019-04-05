public class KeystoneJdbcModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(DataSource.class).toProvider(GuiceDataSourceProvider.bind("auth.jdbc.")).asEagerSingleton();
		JdbcGuiceModule jdbcGuiceModule = new JdbcGuiceModule();
		binder().install(jdbcGuiceModule);
		bind(UserDatabase.class).to(JdbcUserRepository.class).asEagerSingleton();
		bind(ResultSetMappers.class).toProvider(
				ResultSetMappersProvider.build(UserEntity.class, ProjectEntity.class, ServiceAccountEntity.class,
						UserProjectEntity.class, UserCertEntity.class));
	}
}