package com.francis.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francis.tmall.mapper.ProductImageMapper;
import com.francis.tmall.pojo.ProductImage;
import com.francis.tmall.pojo.ProductImageExample;
import com.francis.tmall.service.ProductImageService;

@Service
public class ProductImageServiceImpl implements ProductImageService{
    @Autowired
    ProductImageMapper productImageMapper;

    @Override
    public void add(ProductImage pi) {
        productImageMapper.insert(pi);
    }

    @Override
    public void delete(int id) {
        productImageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ProductImage pi) {
        productImageMapper.updateByPrimaryKeySelective(pi);

    }

    @Override
    public ProductImage get(int id) {
        return productImageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list(int pid, String type) {
        ProductImageExample example =new ProductImageExample();
        example.createCriteria()
                .andPidEqualTo(pid)
                .andTypeEqualTo(type);
        example.setOrderByClause("id desc");
        return productImageMapper.selectByExample(example);
    }

}
