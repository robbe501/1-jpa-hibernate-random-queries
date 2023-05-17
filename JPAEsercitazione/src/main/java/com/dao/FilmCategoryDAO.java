package com.dao;

import java.util.List;

import com.entity.Film;
import com.vo.CategoryVO;

public interface FilmCategoryDAO {
	public List<CategoryVO> getNumFilmsPerOneCategory(String categoryName);

	public List<Film> getFilmsByCategoryDesc(String categoryName);
}
