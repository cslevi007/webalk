package hu.me.iit.webalk.first;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ArticleDto {
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;

		ArticleDto that = (ArticleDto) object;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (author != null ? !author.equals(that.author) : that.author != null) return false;
		if (title != null ? !title.equals(that.title) : that.title != null) return false;
		return pages != null ? pages.equals(that.pages) : that.pages == null;
	}

	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (id != null ? id.hashCode() : 0);
		result = 31 * result + (author != null ? author.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (pages != null ? pages.hashCode() : 0);
		return result;
	}

	@NotNull
	private Long id;

    @NotBlank
    @NotNull
    private String author;
    @NotBlank
    private String title;
    @Min(10)
    private Integer pages;
    
    public ArticleDto() {
    	
    }

    public ArticleDto(String author, String title, Integer pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
	public String toString() {
		return "ArticleDto [id=" + id + ", author=" + author + ", title=" + title + ", pages=" + pages + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}