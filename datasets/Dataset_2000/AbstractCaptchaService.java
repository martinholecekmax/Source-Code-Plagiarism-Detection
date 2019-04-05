public abstract class AbstractCaptchaService implements CaptchaService, Serializable {
    protected void renderCaptcha(RenderedImage image, String format, OutputStream out) throws IOException {
        ImageIO.write(image, format, out);
        out.flush();
    }
}