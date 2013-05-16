package com.sirma.itt.javacourse.collections;

import java.util.List;

/**
 * Contains a list of elements and separates them on pages using the page size that is provided in
 * the constructor.
 * 
 * @param <T>
 *            The type of the elements in the list.
 * @author gdimitrov
 */
public class PageBean<T> {

	private int pageSize;
	private List<T> elements;
	private int currentPage;

	/**
	 * Creates a new PageBean object using the given page size.
	 * 
	 * @param pageSize
	 *            the page size of this PageBean.
	 * @param input
	 *            the elements to be added to the bean.
	 */
	public PageBean(int pageSize, List<T> input) {
		currentPage = -1;
		this.pageSize = pageSize;
		elements = input;
	}

	/**
	 * Gets the next page of the bean.
	 * 
	 * @return a list of the next elements.
	 */
	public List<T> next() {
		if (!hasNext()) {
			return getElements();
		}
		currentPage++;
		return getElements();
	}

	/**
	 * Gets the current page of the bean. The amount of records returned is dependent on the page
	 * size used in the constructor of the class.
	 * 
	 * @return a list of the next elements.
	 */
	private List<T> getElements() {
		int startIndex = currentPage * pageSize;
		int endIndex = startIndex;
		for (int i = 0; i < pageSize; i++) {
			if (currentPage * pageSize + i >= elements.size()) {
				break;
			}
			endIndex++;
		}
		return elements.subList(startIndex, endIndex);
	}

	/**
	 * Gets the previous page of the bean.
	 * 
	 * @return a list of the previous elements.
	 */
	public List<T> previous() {
		if (currentPage <= 0) {
			throw new IndexOutOfBoundsException("You are already at the first page");
		} else {
			currentPage--;
			return getElements();
		}

	}

	/**
	 * Determines if the bean has a next available page.
	 * 
	 * @return true if there is a next page.
	 */
	public boolean hasNext() {
		if ((currentPage + 1) * pageSize <= elements.size()) {
			return true;
		}
		return false;
	}

	/**
	 * Determines if the bean has a previous available page.
	 * 
	 * @return true if there is a previous page.
	 */
	public boolean hasPrevious() {
		if (currentPage <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * Switches the bean to the first page.
	 * 
	 * @return the elements on the first page.
	 */
	public List<T> firstPage() {
		currentPage = 0;
		return getElements();
	}

	/**
	 * Switches the bean to the last page.
	 * 
	 * @return the elements on the last page.
	 */
	public List<T> lastPage() {
		if ((elements.size() % pageSize) == 0) {
			currentPage = elements.size() / pageSize - 1;
		} else {
			currentPage = elements.size() / pageSize;
		}
		return getElements();
	}

	/**
	 * Gets the current page number.
	 * 
	 * @return the current page number.
	 */
	public int getCurrentPageNumber() {
		return currentPage + 1;
	}
}
