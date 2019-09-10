# TextGroupView
ImageView + TextView + TextView +TextView+ EditText +ImageView 实现的组合控件
## JitPack依赖
### A.项目/build.grade
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### B.项目/app/build.grade
```
	dependencies {
	        implementation 'com.github.RelinRan:TextGroupView:1.0.0'
	}
```
# 效果图
![img](https://github.com/RelinRan/TextGroupView/blob/master/ic_rendering.png)
# xml布局
```
    <com.android.view.TextGroupView
        android:layout_width="match_parent"
        android:layout_height="70dp"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="20dp"
        app:left_imageHeight="50dp"
        app:left_imageMarginLeft="10dp"
        app:left_imageScaleType="center_crop"
        app:left_imageSrc="@drawable/ic_head"
        app:left_imageWidth="50dp"
        app:left_textPaddingLeft="10dp"
        app:radius="8dp"
        app:right_imagePaddingRight="10dp"
        app:right_imageSrc="@drawable/ic_arrow"
        app:right_text="更换头像"
        app:right_textColor="#FFFFFF"
        app:solid="#161538"></com.android.view.TextGroupView>

    <com.android.view.TextGroupView
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="20dp"
        app:edit_hintText="输入昵称"
        app:edit_hintTextColor="#FFFFFF"
        app:edit_textColor="#FFFFFF"
        app:left_text="昵称"
        app:left_textColor="#FFFFFF"
        app:left_textPaddingLeft="10dp"
        app:radius="8dp"
        app:right_imagePaddingRight="10dp"
        app:right_imageSrc="@drawable/ic_arrow"
        app:solid="#161538"></com.android.view.TextGroupView>

    <com.android.view.TextGroupView
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="20dp"
        app:left_imagePaddingLeft="10dp"
        app:left_imageSrc="@drawable/ic_item"
        app:left_text="基本信息"
        app:left_textColor="#FFFFFF"
        app:radius="8dp"
        app:right_imagePaddingRight="10dp"
        app:right_imageSrc="@drawable/ic_arrow"
        app:solid="#161538"></com.android.view.TextGroupView>
```


