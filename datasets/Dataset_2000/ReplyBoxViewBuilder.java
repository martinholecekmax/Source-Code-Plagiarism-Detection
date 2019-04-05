public final class ReplyBoxViewBuilder implements UiBuilder, IntrinsicReplyBoxView {
  public interface Resources extends ClientBundle {
    @Source("ReplyBox.css")
    Css css();
  }
  public interface Css extends CssResource {
    
    String replyBox();
    
    String avatar();
  }
  
  public enum Components implements Component {
    
    AVATAR("A");
    private final String postfix;
    Components(String postfix) {
      this.postfix = postfix;
    }
    @Override
    public String getDomId(String baseId) {
      return baseId + postfix;
    }
  }
  
  private final String id;
  
  private final Css css;
        
  private String avatarUrl;
  
  private boolean enabled = true;
  
  public static ReplyBoxViewBuilder create(String id) {
    return new ReplyBoxViewBuilder(WavePanelResourceLoader.getReplyBox().css(), id);
  }
  @VisibleForTesting
  ReplyBoxViewBuilder(Css css, String id) {
            Preconditions.checkArgument(!id.contains("\'"));
    this.css = css;
    this.id = id;
    this.avatarUrl = "static/images/unknown.jpg";
  }
  public void setAvatarImageUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }
        @Override
  public void outputHtml(SafeHtmlBuilder output) {
    openWith(output, id, css.replyBox(), TypeCodes.kind(Type.REPLY_BOX),
        enabled ? "" : "style='display:none'");
    {
            image(output, Components.AVATAR.getDomId(id), css.avatar(),
          EscapeUtils.fromString(avatarUrl), EscapeUtils.fromPlainText("author"), null);
      output.appendEscaped("Click here to reply");
    }
    close(output);
  }
  @Override
  public String getId() {
    return id;
  }
  @Override
  public void enable() {
    setEnabled(true);
  }
  @Override
  public void disable() {
    setEnabled(false);
  }
  private void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}