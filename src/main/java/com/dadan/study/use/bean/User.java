package com.dadan.study.use.bean;

public class User{
	private String id;
    private String name;
    private String sex;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
    	StringBuffer buffer = new StringBuffer();
    	if(this.getId()!=null){
    		buffer.append("id:"+this.getId()+";");
    	}
    	if(this.getAge()>-1){
    		buffer.append("age:"+this.getAge()+";");
    	}
    	if(this.getName()!=null){
    		buffer.append("name:"+this.getName()+";");
    	}
    	if(this.getSex()!=null){
    		buffer.append("sex:"+this.getSex()+";");
    	}
    	return buffer.toString();
    }
}
