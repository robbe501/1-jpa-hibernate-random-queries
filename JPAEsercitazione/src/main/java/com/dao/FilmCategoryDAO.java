package com.dao;

import java.util.List;

import com.vo.CategoryVO;
import com.vo.FilmVO;

public interface FilmCategoryDAO {
	public List<CategoryVO> getNumFilmsPerOneCategory(String categoryName);

	public List<FilmVO> getFilmsByCategoryDesc(String categoryName);
}
