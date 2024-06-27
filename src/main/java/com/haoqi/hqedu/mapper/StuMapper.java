package com.haoqi.hqedu.mapper;

import com.github.pagehelper.ISelect;
import com.haoqi.hqedu.pojo.Stu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StuMapper {

    /**
     * 查询全部学员信息
     * @return
     */
    //@Select("select * from tb_stu")
    public List<Stu> list();

    /**
     * 按照id批量删除学员信息
     */
    //@Delete("delete from tb_stu where id = #{id}")
    void deletebyid(List<Integer> ids);

    /**
     * 新增学员信息
     */
    //@Insert("insert into tb_stu(username,password,name,tel_num) values (#{username},#{password},#{name},#{telNum})")
    void add(Stu stu);

    /**
     * 按照id查询学员信息
     */
    @Select("select id,username,password,name,tel_num from tb_stu where id = #{id}")
    Stu showId(Integer id);

    /**
     *利用xml动态实现更新
     */
    //@Update("update tb_stu set id = #{id},username = #{username},password=#{password},name = #{name},tel_num=#{telNum} where id = #{id}")
    public void update(Stu stu);

    /**
     *
     * 查询学员信息总条数
     * @return
     */
    //@Select("select count(*) from tb_stu")
    //Integer count();

     /**
     * 分页查询学员信息
     * @param start
     * @param pageSize
     * @return
     */
    //@Select("select * from tb_stu limit #{start},#{pageSize}")
    //List<Stu> page(Integer start, Integer pageSize);


    /**
     * pagehelper插件实现员工信息分页查询
     * @return
     */
    //@Select("select * from tb_stu")
    public List<Stu> page(String name);


}
