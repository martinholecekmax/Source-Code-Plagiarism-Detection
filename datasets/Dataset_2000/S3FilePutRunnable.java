public class S3FilePutRunnable implements Runnable
{
	private final Logger logger = LoggerFactory.getLogger(S3FilePutRunnable.class);
	private final String filePath;
	private final S3Settings s3Settings;
	
	public S3FilePutRunnable(String filePath, S3Settings s3Settings)
	{
		this.filePath = filePath;
		this.s3Settings = s3Settings;
	}
	@Override
	public void run()
	{
		boolean createBucket = false;
		boolean doExit = false;
		int attempt = 0;
		final AmazonS3Client s3Client = new AmazonS3Client(this.s3Settings.getAWSCredentials());
		while (!doExit && attempt != this.s3Settings.retryCount)
		{
			try
			{
				if (!s3Settings.mockPut)
				{
					if (createBucket)
					{
						s3Client.createBucket(this.s3Settings.bucketName, this.s3Settings.regionName);
					}
					final File logfile = new File(this.filePath);
					final String keyName = UUID.randomUUID().toString();
					final PutObjectRequest request = new PutObjectRequest(this.s3Settings.bucketName, keyName, logfile);
					s3Client.putObject(request);
				}
				else
				{
					logger.warn("Mocking file POST: {}", this.filePath);
				}
				doExit = true;
			}
			catch (AmazonServiceException ex)
			{
				createBucket = false;
				if (HttpURLConnection.HTTP_NOT_FOUND == ex.getStatusCode() && ex.getErrorCode().equals("NoSuchBucket"))
				{
					createBucket = true;
				}
				else
				{
										doExit = HttpURLConnection.HTTP_FORBIDDEN == ex.getStatusCode();
					if (doExit)
					{
						logger.error(String.format("Authentication error posting %s to AWS.  Will not retry.",
								this.filePath), ex);
					}
					else
					{
						logger.error(String.format("Failed to post %s to AWS", this.filePath), ex);
					}
				}
			}
			catch (AmazonClientException ex)
			{
				createBucket = false;
				logger.error(String.format("Failed to post %s to AWS", this.filePath), ex);
			}
			finally
			{
								if (!createBucket)
				{
					attempt += 1;
				}
			}
		}
	}
}