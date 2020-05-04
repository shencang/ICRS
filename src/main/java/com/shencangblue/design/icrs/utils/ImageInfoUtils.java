package com.shencangblue.design.icrs.utils;

/**
 * @author 姬月
 * Description: 人脸识别图片工具类
 */
public class ImageInfoUtils {
    public byte[] rgbData;
    public int width;
    public int height;

    public byte[] getRgbData() {
        return rgbData;
    }

    public void setRgbData(byte[] rgbData) {
        this.rgbData = rgbData;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
