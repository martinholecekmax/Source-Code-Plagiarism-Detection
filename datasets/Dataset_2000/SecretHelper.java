public class SecretHelper {
	@Inject
	OpsKeyStore keyStore;
		public byte[] encodeItemSecret(SecretKey itemSecret) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			SecretStore.Writer writer = new SecretStore.Writer(baos);
			byte[] plaintext = AesUtils.serialize(itemSecret);
			for (int backend : keyStore.getBackends()) {
				PublicKey publicKey = keyStore.findPublicKey(backend);
				if (publicKey != null) {
					writer.writeAsymetricSystemKey(plaintext, backend, publicKey);
				} else {
					throw new IllegalStateException();
				}
			}
			for (ProjectAuthorization project : OpsContext.get().getEncryptingProjects()) {
				if (project.isLocked()) {
					throw new IllegalStateException();
																																																																																																								}
				writer.writeLockedByProjectKey(plaintext, project.getId(), project.getProjectSecret());
			}
																											writer.close();
			baos.close();
			return baos.toByteArray();
		} catch (IOException e) {
			throw new IllegalStateException("Error serializing key", e);
		}
	}
																																public byte[] decryptSecret(byte[] data, byte[] secret) {
		SecretStore secretStore = new SecretStore(secret);
		SecretKey secretKey = null;
		for (ProjectAuthorization project : OpsContext.get().getEncryptingProjects()) {
			secretKey = secretStore.getSecretFromProject(project);
		}
		if (secretKey == null) {
			throw new SecurityException();
		}
		return AesUtils.decrypt(secretKey, data);
	}
}