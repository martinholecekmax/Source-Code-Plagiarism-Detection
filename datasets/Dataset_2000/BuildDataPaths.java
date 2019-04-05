public interface BuildDataPaths {
  File getDataStorageRoot();
  File getTargetsDataRoot();
  File getTargetTypeDataRoot(BuildTargetType<?> targetType);
  File getTargetDataRoot(BuildTarget<?> target);
}