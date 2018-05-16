/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年4月28日 下午5:28:05
 * @version V1.0
 */
package com.ptxu.retrofit.domain;

/**
 * @ClassName: Hotel
 * @Description: TODO
 * @author dell
 * @date 2018年4月28日 下午5:28:05
 *
 */
public class Hotel {
    private int id;
    private String hotelname;

    public Hotel() {
    }

    public Hotel(int id, String hotelname) {
        this.id = id;
        this.hotelname = hotelname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    /*
     * <p>Title: hashCode</p> <p>Description: </p>
     * 
     * @return
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hotelname == null) ? 0 : hotelname.hashCode());
        result = prime * result + id;
        return result;
    }

    /*
     * <p>Title: equals</p> <p>Description: </p>
     * 
     * @param obj
     * 
     * @return
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hotel other = (Hotel) obj;
        if (hotelname == null) {
            if (other.hotelname != null)
                return false;
        }
        else if (!hotelname.equals(other.hotelname))
            return false;
        if (id != other.id)
            return false;
        return true;
    }

    /*
     * <p>Title: toString</p> <p>Description: </p>
     * 
     * @return
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Hotel [id=" + id + ", hotelname=" + hotelname + "]";
    }

}
