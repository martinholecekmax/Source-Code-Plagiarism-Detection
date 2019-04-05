public class InstallData extends AutomatedInstallData
{
    public InstallData(Variables variables, Platform platform)
    {
        super(variables, platform);
    }
    @Override
    public void setInstallPath(String path)
    {
        super.setInstallPath(path);
        setInstallDriveFromPath(path, INSTALL_DRIVE);
    }
    @Override
    public void setDefaultInstallPath(String path)
    {
        super.setDefaultInstallPath(path);
        setInstallDriveFromPath(path, DEFAULT_INSTALL_DRIVE);
    }
    @Override
    public String getDefaultInstallPath()
    {
        return getVariable(DEFAULT_INSTALL_PATH);
    }
    private void setInstallDriveFromPath(String path, String variable)
    {
        if (OsVersion.IS_WINDOWS)
        {
            String[] parts = path.trim().split(":", 2);
            if (parts.length > 0 && parts[0].length() == 1)
            {
                setVariable(variable, parts[0] + ":");
            }
        }
    }
}