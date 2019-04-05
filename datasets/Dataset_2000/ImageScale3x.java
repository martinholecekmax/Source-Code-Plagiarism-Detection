public class ImageScale3x
{
    
    private int[] srcData;
    
    private int width;
    
    private int height;
    
    public ImageScale3x(BufferedImage srcImage)
    {
        width = srcImage.getWidth();
        height = srcImage.getHeight();
        srcData = new int[width*height];
        srcImage.getRGB(0,0,width,height,srcData,0,width);              
    }
    
    public BufferedImage getScaledImage()
    {
        RawScale3x scaler = new RawScale3x(srcData,width,height);
        BufferedImage image = new BufferedImage(width*3,height*3,BufferedImage.TYPE_INT_ARGB);
        image.setRGB(0,0,width*3,height*3,scaler.getScaledData(),0,width*3);
        return image;
    }
    
    public static void main(String argv[])
    {
        String srcFile = "randam_orig.png";
        try
        {
            System.out.println("Reading: "+srcFile);
            BufferedImage src = ImageIO.read(new File(srcFile));
            ImageScale3x scaler = new ImageScale3x(src);
            BufferedImage out = scaler.getScaledImage();
            String outFile = srcFile.substring(0,srcFile.length()-4);
            outFile += "3x";
            outFile += ".png";
            System.out.println("Writing: "+outFile);
            ImageIO.write(out,"PNG",new File(outFile));
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}