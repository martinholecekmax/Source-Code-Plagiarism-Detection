public interface IContainerArea extends IArea
{
	Iterator<IArea> getChildren( );
	int getChildrenCount( );
	public void addChild( IArea area );
	public boolean needClip( );
	public void setNeedClip( boolean needClip );
	public BoxStyle getBoxStyle( );
	public String getHelpText( );
}