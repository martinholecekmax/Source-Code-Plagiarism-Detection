public class ContentTypes_PDETest extends TestCaseWithProject {
  public void testNonHsContentType() throws CoreException {
    IFile file = project.getFile( "a.c" );
    file.create( new ByteArrayInputStream( new byte[ 0 ] ), true, null );
    assertNull( file.getContentDescription() );
  }
  public void testHaskellContentType() throws CoreException {
    IFile file = project.getFile( "a.hs" );
    file.create( new ByteArrayInputStream( new byte[ 0 ] ), true, null );
    String hsID = "net.sf.eclipsefp.haskell.contenttypes.haskell";
    assertEquals( hsID, file.getContentDescription().getContentType().getId() );
  }
  public void testBirdContentType() throws CoreException {
    IFile file = project.getFile( "a.lhs" );
    String content = "A\n> module A where \nBlabla";
    file.create( new ByteArrayInputStream( content.getBytes() ), true, null );
    String hsID = "net.sf.eclipsefp.haskell.contenttypes.literateHaskell";
    IContentDescription cd = file.getContentDescription();
    assertEquals( hsID, cd.getContentType().getId() );
    assertEquals( LiterateContentDescriber.BIRD,
                  cd.getProperty( LiterateContentDescriber.STYLE ) );
  }
  public void testLatexContentType() throws CoreException {
    IFile file = project.getFile( "a.lhs" );
    String content = "A\n\\begin{code}module A where\\end{code}\nBlabla";
    file.create( new ByteArrayInputStream( content.getBytes() ), true, null );
    String hsID = "net.sf.eclipsefp.haskell.contenttypes.literateHaskell";
    IContentDescription cd = file.getContentDescription();
    assertEquals( hsID, cd.getContentType().getId() );
    assertEquals( LiterateContentDescriber.LATEX,
                  cd.getProperty( LiterateContentDescriber.STYLE ) );
  }
}