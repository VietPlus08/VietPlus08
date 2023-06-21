package com.codegym.blog.service;


import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.BlogDto;
import com.codegym.blog.repo.IBlogRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService {

    final IBlogRepo repo;

    public BlogServiceImpl(IBlogRepo repo) {
        this.repo = repo;
    }

    private static int compare(Blog o1, Blog o2) {
        return o1.getDateOfCreateComment().after(o2.getDateOfCreateComment()) ? 1 : -1;
    }

    @Override
    public void save(Blog blog) {
        repo.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<BlogDto> findAll() {
        List<Blog> blogs = repo.findAll()
                .stream()
                .sorted(BlogServiceImpl::compare)
                .collect(Collectors.toList());
        return blogs.stream()
                .map(BlogDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Blog blog = repo.findById(id).orElse(null);
        assert blog != null;
        repo.delete(blog);
    }

    @Override
    public Page<Blog> findWithPage(Pageable pageable) {
        Page<Blog> blogPage = repo.findAll(pageable);
        return blogPage;
    }
}
