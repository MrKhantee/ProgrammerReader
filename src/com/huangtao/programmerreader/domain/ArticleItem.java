package com.huangtao.programmerreader.domain;

public class ArticleItem {

	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public ArticleItem(String title, String host, String iconUrl) {
		this.title = title;
		this.host = host;
		this.iconUrl = iconUrl;
	}
	private int articleId;
	private String title;
	private String host;
	private String iconUrl;
}
