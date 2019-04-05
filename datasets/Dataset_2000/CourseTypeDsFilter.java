public class CourseTypeDsFilter extends AbstractTypeDsFilter {
    private Long categoryId;
    private Long categoryId_From;
    private Long categoryId_To;
    private String category;
    public Long getCategoryId() {
        return this.categoryId;
    }
    public Long getCategoryId_From() {
        return this.categoryId_From;
    }
    public Long getCategoryId_To() {
        return this.categoryId_To;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public void setCategoryId_From(Long categoryId_From) {
        this.categoryId_From = categoryId_From;
    }
    public void setCategoryId_To(Long categoryId_To) {
        this.categoryId_To = categoryId_To;
    }
    public String getCategory() {
        return this.category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}