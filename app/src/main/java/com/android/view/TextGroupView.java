package com.android.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * By Relin <br/>
 * Date time 2019-09-05 <br/>
 * Item控件<br/>
 * 使用该控件可以达到快速布局图标+文字+文字+文字+输入+图标<br/>
 * 采用ImageView + TextView +TextView + EditText + ImageView的<br/>
 * 方式来制作类似布局的快速开发，为达到一个控件解决多控件布局的<br/>
 * 速度问题，以此来写这个控件来解决布局者的痛点。<br/>
 * Item control<br/>
 * use this control to achieve quick layout icon + text + text + text + image + icon<br/>
 * rapid development of similar layouts to achieve a single control addressing multiple control layouts of<br/>
 * speed issues, write this control to address the layout's pain points. < br / >
 */
public class TextGroupView extends LinearLayout {

    //字体大小
    private final int TEXT_SIZE = (int) (Resources.getSystem().getDisplayMetrics().density * 14);

    //背景属性
    private int solid = Color.parseColor("#FFFFFF");
    private int strokeWidth = 0;
    private int strokeColor = Color.parseColor("#FFFFFF");
    private int shape = 0;
    private float radius = 0;
    private float topLeftRadius = 0;
    private float topRightRadius = 0;
    private float bottomLeftRadius = 0;
    private float bottomRightRadius = 0;

    //所有控件
    private ImageView leftImageView;
    private TextView leftTextView;
    private TextView centerTextView;
    private TextView rightTextView;
    private EditText editView;
    private ImageView centerImageView;
    private ImageView rightImageView;

    private int allTextColor;
    private int allTextSize;
    private int allTextGravity;
    private float allTextWeight;

    //左边图片控件属性
    private int leftImageSrc;
    private int leftImageBackground;
    private int leftImageWidth;
    private int leftImageHeight;
    private int leftImageScaleType;
    private int leftImageMargin;
    private int leftImageMarginLeft;
    private int leftImageMarginTop;
    private int leftImageMarginRight;
    private int leftImageMarginBottom;
    private int leftImagePadding;
    private int leftImagePaddingLeft;
    private int leftImagePaddingTop;
    private int leftImagePaddingRight;
    private int leftImagePaddingBottom;

    //左边文字控件属性
    private int leftTextBackground;
    private String leftText;
    private float leftTextSize;
    private int leftTextColor;
    private int leftTextGravity;
    private float leftTextWeight;
    private int leftTextMargin;
    private int leftTextMarginLeft;
    private int leftTextMarginTop;
    private int leftTextMarginRight;
    private int leftTextMarginBottom;
    private int leftTextPadding;
    private int leftTextPaddingLeft;
    private int leftTextPaddingTop;
    private int leftTextPaddingRight;
    private int leftTextPaddingBottom;

    //中间文字控件属性
    private int centerTextBackground;
    private String centerText;
    private int centerTextSize;
    private int centerTextColor;
    private int centerTextGravity;
    private float centerTextWeight;
    private int centerTextMargin;
    private int centerTextMarginLeft;
    private int centerTextMarginTop;
    private int centerTextMarginRight;
    private int centerTextMarginBottom;
    private int centerTextPadding;
    private int centerTextPaddingLeft;
    private int centerTextPaddingTop;
    private int centerTextPaddingRight;
    private int centerTextPaddingBottom;

    //右边文字控件属性
    private int rightTextBackground;
    private String rightText;
    private int rightTextSize;
    private int rightTextColor;
    private int rightTextGravity;
    private float rightTextWeight;
    private int rightTextMargin;
    private int rightTextMarginLeft;
    private int rightTextMarginTop;
    private int rightTextMarginRight;
    private int rightTextMarginBottom;
    private int rightTextPadding;
    private int rightTextPaddingLeft;
    private int rightTextPaddingTop;
    private int rightTextPaddingRight;
    private int rightTextPaddingBottom;

    //右边输入控件属性
    private int editWidth;
    private int editHeight;
    private boolean editFocusable;
    private int editHintTextColor;
    private String editHintText;
    private int editBackground;
    private boolean editSingleLine;
    private int editMaxLines;
    private int editMaxLength;
    private String editDigits;
    private int editEllipsize;
    private int editInputType;
    private float editWeight;

    private String editText;
    private int editTextSize;
    private int editTextColor;
    private int editGravity;
    private int editMargin;
    private int editMarginLeft;
    private int editMarginTop;
    private int editMarginRight;
    private int editMarginBottom;
    private int editPadding;
    private int editPaddingLeft;
    private int editPaddingTop;
    private int editPaddingRight;
    private int editPaddingBottom;


    //中间图片控件属性
    private int centerImageSrc;
    private int centerImageBackground;
    private int centerImageWidth;
    private int centerImageHeight;
    private int centerImageScaleType;
    private int centerImageMargin;
    private int centerImageMarginLeft;
    private int centerImageMarginTop;
    private int centerImageMarginRight;
    private int centerImageMarginBottom;
    private int centerImagePadding;
    private int centerImagePaddingLeft;
    private int centerImagePaddingTop;
    private int centerImagePaddingRight;
    private int centerImagePaddingBottom;

    //右边图片控件属性
    private int rightImageSrc;
    private int rightImageBackground;
    private int rightImageWidth;
    private int rightImageHeight;
    private int rightImageScaleType;
    private int rightImageMargin;
    private int rightImageMarginLeft;
    private int rightImageMarginTop;
    private int rightImageMarginRight;
    private int rightImageMarginBottom;
    private int rightImagePadding;
    private int rightImagePaddingLeft;
    private int rightImagePaddingTop;
    private int rightImagePaddingRight;
    private int rightImagePaddingBottom;

    /**
     * 图片缩放属性
     */
    private ImageView.ScaleType[] scaleTypes = {
            ImageView.ScaleType.MATRIX,
            ImageView.ScaleType.FIT_XY,
            ImageView.ScaleType.FIT_START,
            ImageView.ScaleType.FIT_CENTER,
            ImageView.ScaleType.FIT_END,
            ImageView.ScaleType.CENTER,
            ImageView.ScaleType.CENTER_CROP,
            ImageView.ScaleType.CENTER_INSIDE,
    };

    /**
     * 文本显示
     */
    private TextUtils.TruncateAt[] truncateAts = {
            TextUtils.TruncateAt.START,
            TextUtils.TruncateAt.MIDDLE,
            TextUtils.TruncateAt.END,
            TextUtils.TruncateAt.MARQUEE
    };

    public static int INPUT_TYPE_TEXT = 0;
    public static int INPUT_TYPE_PASSWORD = 1;
    public static int INPUT_TYPE_VISIBLE_PASSWORD = 2;
    public static int INPUT_TYPE_NUMBER_PASSWORD = 3;
    public static int INPUT_TYPE_NUMBER = 4;

    /**
     * 输入类型
     */
    private int[] inputTypes = {
            android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_NORMAL,
            android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD,
            android.text.InputType.TYPE_CLASS_NUMBER | android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL,
            android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD,
            android.text.InputType.TYPE_CLASS_NUMBER | android.text.InputType.TYPE_NUMBER_VARIATION_PASSWORD,
            android.text.InputType.TYPE_CLASS_NUMBER | android.text.InputType.TYPE_NUMBER_VARIATION_NORMAL,
    };

    public TextGroupView(Context context) {
        super(context);
        initAttrs(context, null);
    }

    public TextGroupView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public TextGroupView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    /**
     * 初始化属性
     *
     * @param context 上下文
     * @param attrs   属性
     */
    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextGroupView);
            solid = typedArray.getColor(R.styleable.TextGroupView_solid, solid);
            strokeWidth = (int) typedArray.getDimension(R.styleable.TextGroupView_strokeWidth, strokeWidth);
            strokeColor = typedArray.getColor(R.styleable.TextGroupView_strokeColor, strokeColor);
            if (typedArray.getString(R.styleable.TextGroupView_shape) != null) {
                shape = Integer.parseInt(typedArray.getString(R.styleable.TextGroupView_shape));
            }
            radius = typedArray.getDimension(R.styleable.TextGroupView_radius, 0);
            topLeftRadius = typedArray.getDimension(R.styleable.TextGroupView_topLeftRadius, 0);
            topRightRadius = typedArray.getDimension(R.styleable.TextGroupView_topRightRadius, 0);
            bottomLeftRadius = typedArray.getDimension(R.styleable.TextGroupView_bottomLeftRadius, 0);
            bottomRightRadius = typedArray.getDimension(R.styleable.TextGroupView_bottomRightRadius, 0);

            allTextColor = typedArray.getColor(R.styleable.TextGroupView_all_textColor, 0);
            allTextSize = typedArray.getDimensionPixelSize(R.styleable.TextGroupView_all_textSize, 0);
            allTextGravity = typedArray.getInt(R.styleable.TextGroupView_all_textGravity, 0);
            allTextWeight = typedArray.getFloat(R.styleable.TextGroupView_all_textWeight, 0);

            //左边图片
            leftImageSrc = typedArray.getResourceId(R.styleable.TextGroupView_left_imageSrc, 0);
            leftImageBackground = typedArray.getResourceId(R.styleable.TextGroupView_left_imageBackground, 0);
            leftImageWidth = typedArray.getLayoutDimension(R.styleable.TextGroupView_left_imageWidth, LayoutParams.WRAP_CONTENT);
            leftImageHeight = typedArray.getLayoutDimension(R.styleable.TextGroupView_left_imageHeight, LayoutParams.WRAP_CONTENT);
            leftImageScaleType = typedArray.getInt(R.styleable.TextGroupView_left_imageScaleType, 0);
            leftImageMargin = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imageMargin, 0);
            leftImageMarginLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imageMarginLeft, 10);
            leftImageMarginTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imageMarginTop, 0);
            leftImageMarginRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imageMarginRight, 0);
            leftImageMarginBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imageMarginBottom, 0);
            leftImagePadding = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imagePadding, 0);
            leftImagePaddingLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imagePaddingLeft, 0);
            leftImagePaddingTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imagePaddingTop, 0);
            leftImagePaddingRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imagePaddingRight, 0);
            leftImagePaddingBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_imagePaddingBottom, 0);
            //左边文字
            leftTextBackground = typedArray.getResourceId(R.styleable.TextGroupView_left_textBackground, 0);
            leftText = typedArray.getString(R.styleable.TextGroupView_left_text);
            leftTextColor = typedArray.getColor(R.styleable.TextGroupView_left_textColor, Color.BLACK);
            leftTextSize = typedArray.getDimension(R.styleable.TextGroupView_left_textSize, TEXT_SIZE);
            leftTextGravity = typedArray.getInt(R.styleable.TextGroupView_left_textGravity, Gravity.LEFT | Gravity.CENTER_VERTICAL);
            leftTextWeight = typedArray.getFloat(R.styleable.TextGroupView_left_textWeight, -1);
            leftTextMargin = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textMargin, 0);
            leftTextMarginLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textMarginLeft, 10);
            leftTextMarginTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textMarginTop, 0);
            leftTextMarginRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textMarginRight, 10);
            leftTextMarginBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textMarginBottom, 0);
            leftTextPadding = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textPadding, 0);
            leftTextPaddingLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textPaddingLeft, 0);
            leftTextPaddingTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textPaddingTop, 0);
            leftTextPaddingRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textPaddingRight, 0);
            leftTextPaddingBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_left_textPaddingBottom, 0);
            //中间文字
            centerTextBackground = typedArray.getResourceId(R.styleable.TextGroupView_center_textBackground, 0);
            centerText = typedArray.getString(R.styleable.TextGroupView_center_text);
            centerTextColor = typedArray.getColor(R.styleable.TextGroupView_center_textColor, Color.BLACK);
            centerTextSize = typedArray.getDimensionPixelSize(R.styleable.TextGroupView_center_textSize, TEXT_SIZE);
            centerTextGravity = typedArray.getInt(R.styleable.TextGroupView_center_textGravity, Gravity.LEFT | Gravity.CENTER_VERTICAL);
            centerTextWeight = typedArray.getInt(R.styleable.TextGroupView_center_textWeight, 1);
            centerTextMargin = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textMargin, 0);
            centerTextMarginLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textMarginLeft, 10);
            centerTextMarginTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textMarginTop, 0);
            centerTextMarginRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textMarginRight, 10);
            centerTextMarginBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textMarginBottom, 0);
            centerTextPadding = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textPadding, 0);
            centerTextPaddingLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textPaddingLeft, 0);
            centerTextPaddingTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textPaddingTop, 0);
            centerTextPaddingRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textPaddingRight, 0);
            centerTextPaddingBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_textPaddingBottom, 0);
            //右边文字
            rightTextBackground = typedArray.getResourceId(R.styleable.TextGroupView_right_textBackground, 0);
            rightText = typedArray.getString(R.styleable.TextGroupView_right_text);
            rightTextColor = typedArray.getColor(R.styleable.TextGroupView_right_textColor, Color.BLACK);
            rightTextSize = typedArray.getDimensionPixelSize(R.styleable.TextGroupView_right_textSize, TEXT_SIZE);
            rightTextGravity = typedArray.getInt(R.styleable.TextGroupView_right_textGravity, Gravity.LEFT | Gravity.CENTER_VERTICAL);
            rightTextWeight = typedArray.getInt(R.styleable.TextGroupView_right_textWeight, -1);
            rightTextMargin = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textMargin, 0);
            rightTextMarginLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textMarginLeft, 0);
            rightTextMarginTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textMarginTop, 0);
            rightTextMarginRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textMarginRight, 0);
            rightTextMarginBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textMarginBottom, 0);
            rightTextPadding = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textPadding, 0);
            rightTextPaddingLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textPaddingLeft, 0);
            rightTextPaddingTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textPaddingTop, 0);
            rightTextPaddingRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textPaddingRight, 0);
            rightTextPaddingBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_textPaddingBottom, 0);
            //右边输入
            editWidth = typedArray.getLayoutDimension(R.styleable.TextGroupView_edit_width, LayoutParams.WRAP_CONTENT);
            editHeight = typedArray.getLayoutDimension(R.styleable.TextGroupView_edit_height, LayoutParams.WRAP_CONTENT);
            editHintTextColor = typedArray.getColor(R.styleable.TextGroupView_edit_hintTextColor, Color.parseColor("#B9B9B9"));
            editFocusable = typedArray.getBoolean(R.styleable.TextGroupView_edit_focusable, true);
            editHintText = typedArray.getString(R.styleable.TextGroupView_edit_hintText);
            editBackground = typedArray.getResourceId(R.styleable.TextGroupView_edit_background, 0);
            editMaxLines = typedArray.getInt(R.styleable.TextGroupView_edit_maxLines, 0);
            editMaxLength = typedArray.getInt(R.styleable.TextGroupView_edit_maxLength, Integer.MAX_VALUE);
            editDigits = typedArray.getString(R.styleable.TextGroupView_edit_digits);
            editEllipsize = typedArray.getInt(R.styleable.TextGroupView_edit_ellipsize, 0);
            editSingleLine = typedArray.getBoolean(R.styleable.TextGroupView_edit_singleLine, false);
            editInputType = typedArray.getInt(R.styleable.TextGroupView_edit_inputType, 0);
            editText = typedArray.getString(R.styleable.TextGroupView_edit_text);
            editTextColor = typedArray.getColor(R.styleable.TextGroupView_edit_textColor, Color.BLACK);
            editTextSize = typedArray.getDimensionPixelSize(R.styleable.TextGroupView_edit_textSize, TEXT_SIZE);
            editGravity = typedArray.getInt(R.styleable.TextGroupView_edit_gravity, Gravity.LEFT | Gravity.CENTER_VERTICAL);
            editWeight = typedArray.getInt(R.styleable.TextGroupView_edit_weight, -1);
            editMargin = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_margin, 0);
            editMarginLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_marginLeft, 20);
            editMarginTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_marginTop, 0);
            editMarginRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_marginRight, 20);
            editMarginBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_marginBottom, 0);
            editPadding = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_padding, 0);
            editPaddingLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_paddingLeft, 0);
            editPaddingTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_paddingTop, 0);
            editPaddingRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_paddingRight, 0);
            editPaddingBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_edit_paddingBottom, 0);
            //中间边图片
            centerImageSrc = typedArray.getResourceId(R.styleable.TextGroupView_center_imageSrc, 0);
            centerImageBackground = typedArray.getResourceId(R.styleable.TextGroupView_center_imageBackground, 0);
            centerImageWidth = typedArray.getLayoutDimension(R.styleable.TextGroupView_center_imageWidth, LayoutParams.WRAP_CONTENT);
            centerImageHeight = typedArray.getLayoutDimension(R.styleable.TextGroupView_center_imageHeight, LayoutParams.WRAP_CONTENT);
            centerImageScaleType = typedArray.getInt(R.styleable.TextGroupView_center_imageScaleType, 0);
            centerImageMargin = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_imageMargin, 0);
            centerImageMarginLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_imageMarginLeft, 0);
            centerImageMarginTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_imageMarginTop, 0);
            centerImageMarginRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_imageMarginRight, 0);
            centerImageMarginBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imageMarginBottom, 0);
            centerImagePadding = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_imagePadding, 0);
            centerImagePaddingLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_imagePaddingLeft, 0);
            centerImagePaddingTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_imagePaddingTop, 0);
            centerImagePaddingRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_imagePaddingRight, 0);
            centerImagePaddingBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_center_imagePaddingBottom, 0);
            //右边边图片
            rightImageSrc = typedArray.getResourceId(R.styleable.TextGroupView_right_imageSrc, 0);
            rightImageBackground = typedArray.getResourceId(R.styleable.TextGroupView_right_imageBackground, 0);
            rightImageWidth = typedArray.getLayoutDimension(R.styleable.TextGroupView_right_imageWidth, LayoutParams.WRAP_CONTENT);
            rightImageHeight = typedArray.getLayoutDimension(R.styleable.TextGroupView_right_imageHeight, LayoutParams.WRAP_CONTENT);
            rightImageScaleType = typedArray.getInt(R.styleable.TextGroupView_right_imageScaleType, 0);
            rightImageMargin = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imageMargin, 0);
            rightImageMarginLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imageMarginLeft, 0);
            rightImageMarginTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imageMarginTop, 0);
            rightImageMarginRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imageMarginRight, 0);
            rightImageMarginBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imageMarginBottom, 0);
            rightImagePadding = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imagePadding, 0);
            rightImagePaddingLeft = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imagePaddingLeft, 0);
            rightImagePaddingTop = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imagePaddingTop, 0);
            rightImagePaddingRight = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imagePaddingRight, 0);
            rightImagePaddingBottom = typedArray.getDimensionPixelOffset(R.styleable.TextGroupView_right_imagePaddingBottom, 0);
        }
        setBackground();
        //设置内容对齐方式
        setGravity(Gravity.CENTER_VERTICAL);
        //添加视图（ImageView + TextView +TextView + EditText + ImageView + ImageView）
        leftImageView = new ImageView(context);
        leftImageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(leftImageView);
        leftTextView = new TextView(context);
        leftTextView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(leftTextView);
        centerTextView = new TextView(context);
        centerTextView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(centerTextView);
        rightTextView = new TextView(context);
        rightTextView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(rightTextView);
        editView = new EditText(context);
        editView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));
        addView(editView);
        centerImageView = new ImageView(context);
        centerImageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(centerImageView);
        rightImageView = new ImageView(context);
        rightImageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        addView(rightImageView);
        //左边图标
        leftImageView.setImageResource(leftImageSrc);
        leftImageView.setBackgroundResource(leftImageBackground);
        leftImageView.setScaleType(scaleTypes[leftImageScaleType]);
        setParams(leftImageView, leftImageWidth, leftImageHeight);
        setMarginPaddingWeight(leftImageView, leftImageMargin, leftImageMarginLeft, leftImageMarginTop, leftImageMarginRight, leftImageMarginBottom, leftImagePadding, leftImagePaddingLeft, leftImagePaddingTop, leftImagePaddingRight, leftImagePaddingBottom, -1);
        //左边文字
        setMarginPaddingWeight(leftTextView, leftTextMargin, leftTextMarginLeft, leftTextMarginTop, leftTextMarginRight, leftTextMarginBottom, leftTextPadding, leftTextPaddingLeft, leftTextPaddingTop, leftTextPaddingRight, leftTextPaddingBottom, leftTextWeight);
        leftTextView.setBackgroundResource(leftTextBackground);
        leftTextView.setText(leftText);
        leftTextView.setTextColor(leftTextColor);
        leftTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize);
        leftTextView.setGravity(leftTextGravity);
        //中间文字
        centerTextView.setBackgroundResource(centerTextBackground);
        centerTextView.setText(centerText);
        centerTextView.setTextColor(centerTextColor);
        centerTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, centerTextSize);
        centerTextView.setGravity(centerTextGravity);
        setMarginPaddingWeight(centerTextView, centerTextMargin, centerTextMarginLeft, centerTextMarginTop, centerTextMarginRight, centerTextMarginBottom, centerTextPadding, centerTextPaddingLeft, centerTextPaddingTop, centerTextPaddingRight, centerTextPaddingBottom, centerTextWeight);
        //右边文字
        setMarginPaddingWeight(rightTextView, rightTextMargin, rightTextMarginLeft, rightTextMarginTop, rightTextMarginRight, rightTextMarginBottom, rightTextPadding, rightTextPaddingLeft, rightTextPaddingTop, rightTextPaddingRight, rightTextPaddingBottom, rightTextWeight);
        rightTextView.setBackgroundResource(rightTextBackground);
        rightTextView.setText(rightText);
        rightTextView.setTextColor(rightTextColor);
        rightTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextSize);
        rightTextView.setGravity(rightTextGravity);
        //右边输入
        setParams(editView, editWidth, editHeight);
        setMarginPaddingWeight(editView, editMargin, editMarginLeft, editMarginTop, editMarginRight, editMarginBottom, editPadding, editPaddingLeft, editPaddingTop, editPaddingRight, editPaddingBottom, editWeight);
        if (!TextUtils.isEmpty(editText)) {
            editView.setText(editText);
        }
        editView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(editMaxLength)});
        editView.setTextColor(editTextColor);
        editView.setFocusable(editFocusable);
        editView.setHintTextColor(editHintTextColor);
        editView.setHint(editHintText);
        editView.setBackgroundResource(editBackground);
        editView.setSingleLine(editSingleLine);
        if (editMaxLines != 0) {
            editView.setMaxLines(editMaxLines);
        }
        if (!TextUtils.isEmpty(editDigits)) {
            editView.setKeyListener(DigitsKeyListener.getInstance(editDigits));
        }
        editView.setEllipsize(truncateAts[editEllipsize]);
        editView.setInputType(inputTypes[editInputType]);
        editView.setText(editText);
        editView.setTextColor(editTextColor);
        editView.setTextSize(TypedValue.COMPLEX_UNIT_PX, editTextSize);
        editView.setGravity(editGravity);
        //中间图标
        setMarginPaddingWeight(centerImageView, centerImageMargin, centerImageMarginLeft, centerImageMarginTop, centerImageMarginRight, centerImageMarginBottom, centerImagePadding, centerImagePaddingLeft, centerImagePaddingTop, centerImagePaddingRight, centerImagePaddingBottom, -1);
        centerImageView.setImageResource(centerImageSrc);
        centerImageView.setBackgroundResource(centerImageBackground);
        centerImageView.setScaleType(scaleTypes[centerImageScaleType]);
        setParams(centerImageView, centerImageWidth, centerImageHeight);
        //右边图标
        setMarginPaddingWeight(rightImageView, rightImageMargin, rightImageMarginLeft, rightImageMarginTop, rightImageMarginRight, rightImageMarginBottom, rightImagePadding, rightImagePaddingLeft, rightImagePaddingTop, rightImagePaddingRight, rightImagePaddingBottom, -1);
        rightImageView.setImageResource(rightImageSrc);
        rightImageView.setBackgroundResource(rightImageBackground);
        rightImageView.setScaleType(scaleTypes[rightImageScaleType]);
        setParams(rightImageView, rightImageWidth, rightImageHeight);
        //全属性
        setAllTextSize();
        setAllTextColor();
        setAllTextGravity();
        setAllTextWeight();
    }

    private void setBackground() {
        Drawable drawable = createShape(shape, strokeWidth, strokeColor, solid, radius, topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    /**
     * 设置宽高
     *
     * @param view   控件
     * @param width  宽度
     * @param height 高度
     */
    private void setParams(View view, int width, int height) {
        LayoutParams params = (LayoutParams) view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }

    /**
     * 设置功全属性 - 字体大小
     */
    private void setAllTextSize() {
        if (allTextSize != 0) {
            leftTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, allTextSize);
            centerTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, allTextSize);
            rightTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, allTextSize);
            editView.setTextSize(TypedValue.COMPLEX_UNIT_PX, allTextSize);
        }
    }

    /**
     * 设置功全属性 - 字体颜色
     */
    private void setAllTextColor() {
        if (allTextColor != 0) {
            leftTextView.setTextColor(allTextColor);
            centerTextView.setTextColor(allTextColor);
            rightTextView.setTextColor(allTextColor);
            editView.setTextColor(allTextColor);
        }
    }

    /**
     * 设置功全属性 - 字体对齐方式
     */
    private void setAllTextGravity() {
        if (allTextGravity != 0) {
            leftTextView.setGravity(allTextGravity);
            centerTextView.setGravity(allTextGravity);
            rightTextView.setGravity(allTextGravity);
            editView.setGravity(allTextGravity);
        }
    }

    /**
     * 设置功全属性 - 权重
     */
    private void setAllTextWeight() {
        if (allTextWeight != 0) {
            setWeight(leftTextView, allTextWeight);
            setWeight(centerTextView, allTextWeight);
            setWeight(rightTextView, allTextWeight);
            setWeight(editView, allTextWeight);
        }
    }

    /**
     * 设置View间距、内间距、权重
     *
     * @param view          控件
     * @param margin        间距（左、上、右、下同时）
     * @param leftMargin    左间距
     * @param topMargin     上间距
     * @param rightMargin   右间距
     * @param bottomMargin  底部间距
     * @param padding       内间距（左、上、右、下同时）
     * @param leftPadding   左内间距
     * @param topPadding    右内间距
     * @param rightPadding  右内间距
     * @param bottomPadding 底部内间距
     * @param weight        权重
     */
    private void setMarginPaddingWeight(View view, int margin, int leftMargin, int topMargin, int rightMargin, int bottomMargin, int padding, int leftPadding, int topPadding, int rightPadding, int bottomPadding, float weight) {
        LinearLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        if (weight != -1) {
            params.weight = weight;
        }
        params.leftMargin = leftMargin;
        params.topMargin = topMargin;
        params.rightMargin = rightMargin;
        params.bottomMargin = bottomMargin;
        if (margin != 0) {
            params.leftMargin = margin;
            params.topMargin = margin;
            params.rightMargin = margin;
            params.bottomMargin = margin;
        }
        view.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
        if (padding != 0) {
            view.setPadding(padding, padding, padding, padding);
        }
        view.setLayoutParams(params);
    }

    /**
     * 设置权重
     *
     * @param view   控件
     * @param weight 权重
     */
    private void setWeight(View view, float weight) {
        LinearLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        if (weight != -1) {
            params.weight = weight;
        }
        view.setLayoutParams(params);
    }

    /**
     * 设置外边距
     *
     * @param view         控件
     * @param margin       边距（左上右下）
     * @param leftMargin   左边距
     * @param topMargin    上边距
     * @param rightMargin  右边距
     * @param bottomMargin 底部间距
     */
    private void setMargin(View view, int margin, int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
        LinearLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        params.leftMargin = leftMargin;
        params.topMargin = topMargin;
        params.rightMargin = rightMargin;
        params.bottomMargin = bottomMargin;
        if (margin != 0) {
            params.leftMargin = margin;
            params.topMargin = margin;
            params.rightMargin = margin;
            params.bottomMargin = margin;
        }
        view.setLayoutParams(params);
    }

    /**
     * 设置内间距
     *
     * @param view          控件
     * @param padding       内间距（左上右下）
     * @param leftPadding   左内间距
     * @param topPadding    上内间距
     * @param rightPadding  右内间距
     * @param bottomPadding 底部内间距
     */
    private void setPadding(View view, int padding, int leftPadding, int topPadding, int rightPadding, int bottomPadding) {
        LinearLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        view.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
        if (padding != 0) {
            view.setPadding(padding, padding, padding, padding);
        }
        view.setLayoutParams(params);
    }

    /**
     * 创建Shape
     * 这个方法是为了创建一个Shape来替代xml创建Shape.
     * create shape drawable
     * this method create you self background drawable
     * by shape.the same as code in xml.
     *
     * @param shape             类型 GradientDrawable.RECTANGLE  GradientDrawable.OVAL
     * @param strokeWidth       外线宽度 button stroke width
     * @param strokeColor       外线颜色 button stroke color
     * @param solidColor        填充颜色 button background color
     * @param cornerRadius      圆角大小 all corner is the same as is the radius
     * @param topLeftRadius     左上圆角 top left corner radius
     * @param topRightRadius    右上圆角 top right corner radius
     * @param bottomLeftRadius  底左圆角  bottom left corner radius
     * @param bottomRightRadius 底右圆角 bottom right corner radius
     * @return
     */
    public Drawable createShape(int shape, int strokeWidth,
                                int strokeColor, int solidColor, float cornerRadius,
                                float topLeftRadius, float topRightRadius,
                                float bottomLeftRadius, float bottomRightRadius) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(shape);
        drawable.setSize(10, 10);
        drawable.setStroke(strokeWidth, strokeColor);
        drawable.setColor(solidColor);
        if (cornerRadius != 0) {
            drawable.setCornerRadius(cornerRadius);
        } else {
            drawable.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomLeftRadius, bottomLeftRadius, bottomRightRadius, bottomRightRadius});
        }
        return drawable;
    }

    public int getSolid() {
        return solid;
    }

    public void setSolid(int solid) {
        this.solid = solid;
        setBackground();
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        setBackground();
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        setBackground();
    }

    public int getShape() {
        return shape;
    }

    public void setShape(int shape) {
        this.shape = shape;
        setBackground();
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
        setBackground();
    }

    public float getTopLeftRadius() {
        return topLeftRadius;
    }

    public void setTopLeftRadius(float topLeftRadius) {
        this.topLeftRadius = topLeftRadius;
        setBackground();
    }

    public float getTopRightRadius() {
        return topRightRadius;
    }

    public void setTopRightRadius(float topRightRadius) {
        this.topRightRadius = topRightRadius;
        setBackground();
    }

    public float getBottomLeftRadius() {
        return bottomLeftRadius;
    }

    public void setBottomLeftRadius(float bottomLeftRadius) {
        this.bottomLeftRadius = bottomLeftRadius;
        setBackground();
    }

    public float getBottomRightRadius() {
        return bottomRightRadius;
    }

    public void setBottomRightRadius(float bottomRightRadius) {
        this.bottomRightRadius = bottomRightRadius;
        setBackground();
    }

    public ImageView getLeftImageView() {
        return leftImageView;
    }

    public void setLeftImageView(ImageView leftImageView) {
        this.leftImageView = leftImageView;
    }

    public TextView getLeftTextView() {
        return leftTextView;
    }

    public void setLeftTextView(TextView leftTextView) {
        this.leftTextView = leftTextView;
    }

    public TextView getCenterTextView() {
        return centerTextView;
    }

    public void setCenterTextView(TextView centerTextView) {
        this.centerTextView = centerTextView;
    }

    public TextView getRightTextView() {
        return rightTextView;
    }

    public void setRightTextView(TextView rightTextView) {
        this.rightTextView = rightTextView;
    }

    public EditText getEditView() {
        return editView;
    }

    public void setEditView(EditText editView) {
        this.editView = editView;
    }

    public ImageView getRightImageView() {
        return rightImageView;
    }

    public void setRightImageView(ImageView rightImageView) {
        this.rightImageView = rightImageView;
    }

    public int getAllTextColor() {
        return allTextColor;
    }

    public void setAllTextColor(int allTextColor) {
        this.allTextColor = allTextColor;
        setAllTextColor();
    }

    public int getAllTextSize() {
        return allTextSize;
    }

    public void setAllTextSize(int allTextSize) {
        this.allTextSize = allTextSize;
        setAllTextSize();
    }

    public int getAllTextGravity() {
        return allTextGravity;
    }

    public void setAllTextGravity(int allTextGravity) {
        this.allTextGravity = allTextGravity;
        setAllTextGravity();
    }

    public float getAllTextWeight() {
        return allTextWeight;
    }

    public void setAllTextWeight(float allTextWeight) {
        this.allTextWeight = allTextWeight;
        setAllTextWeight();
    }

    public int getLeftImageSrc() {
        return leftImageSrc;
    }

    public void setLeftImageSrc(int leftImageSrc) {
        this.leftImageSrc = leftImageSrc;
        leftImageView.setImageResource(leftImageSrc);
    }

    public int getLeftImageBackground() {
        return leftImageBackground;
    }

    public void setLeftImageBackground(int leftImageBackground) {
        this.leftImageBackground = leftImageBackground;
        leftImageView.setBackgroundResource(leftImageBackground);
    }

    public int getLeftImageWidth() {
        return leftImageWidth;
    }

    public void setLeftImageWidth(int leftImageWidth) {
        this.leftImageWidth = leftImageWidth;
        setParams(leftImageView, leftImageWidth, leftImageHeight);
    }

    public int getLeftImageHeight() {
        return leftImageHeight;
    }

    public void setLeftImageHeight(int leftImageHeight) {
        this.leftImageHeight = leftImageHeight;
        setParams(leftImageView, leftImageWidth, leftImageHeight);
    }

    public ImageView.ScaleType getLeftImageScaleType() {
        return scaleTypes[leftImageScaleType];
    }

    public void setLeftImageScaleType(ImageView.ScaleType scaleType) {
        for (int i = 0; i < scaleTypes.length; i++) {
            if (scaleTypes[i] == scaleType) {
                this.leftImageScaleType = i;
            }
        }
        leftImageView.setScaleType(scaleType);
    }

    public int getLeftImageMargin() {
        return leftImageMargin;
    }

    public void setLeftImageMargin(int leftImageMargin) {
        this.leftImageMargin = leftImageMargin;
        setMargin(leftImageView, leftImageMargin, leftImageMarginLeft, leftImageMarginTop, leftImageMarginRight, leftImageMarginBottom);
    }

    public int getLeftImageMarginLeft() {
        return leftImageMarginLeft;
    }

    public void setLeftImageMarginLeft(int leftImageMarginLeft) {
        this.leftImageMarginLeft = leftImageMarginLeft;
        setMargin(leftImageView, leftImageMargin, leftImageMarginLeft, leftImageMarginTop, leftImageMarginRight, leftImageMarginBottom);
    }

    public int getLeftImageMarginTop() {
        return leftImageMarginTop;
    }

    public void setLeftImageMarginTop(int leftImageMarginTop) {
        this.leftImageMarginTop = leftImageMarginTop;
        setMargin(leftImageView, leftImageMargin, leftImageMarginLeft, leftImageMarginTop, leftImageMarginRight, leftImageMarginBottom);
    }

    public int getLeftImageMarginRight() {
        return leftImageMarginRight;
    }

    public void setLeftImageMarginRight(int leftImageMarginRight) {
        this.leftImageMarginRight = leftImageMarginRight;
        setMargin(leftImageView, leftImageMargin, leftImageMarginLeft, leftImageMarginTop, leftImageMarginRight, leftImageMarginBottom);
    }

    public int getLeftImageMarginBottom() {
        return leftImageMarginBottom;
    }

    public void setLeftImageMarginBottom(int leftImageMarginBottom) {
        this.leftImageMarginBottom = leftImageMarginBottom;
        setMargin(leftImageView, leftImageMargin, leftImageMarginLeft, leftImageMarginTop, leftImageMarginRight, leftImageMarginBottom);
    }

    public int getLeftImagePadding() {
        return leftImagePadding;
    }

    public void setLeftImagePadding(int leftImagePadding) {
        this.leftImagePadding = leftImagePadding;
        setPadding(leftImageView, leftImagePadding, leftImagePaddingLeft, leftImagePaddingTop, leftImagePaddingRight, leftImagePaddingBottom);
    }

    public int getLeftImagePaddingLeft() {
        return leftImagePaddingLeft;
    }

    public void setLeftImagePaddingLeft(int leftImagePaddingLeft) {
        this.leftImagePaddingLeft = leftImagePaddingLeft;
        setPadding(leftImageView, leftImagePadding, leftImagePaddingLeft, leftImagePaddingTop, leftImagePaddingRight, leftImagePaddingBottom);
    }

    public int getLeftImagePaddingTop() {
        return leftImagePaddingTop;
    }

    public void setLeftImagePaddingTop(int leftImagePaddingTop) {
        this.leftImagePaddingTop = leftImagePaddingTop;
        setPadding(leftImageView, leftImagePadding, leftImagePaddingLeft, leftImagePaddingTop, leftImagePaddingRight, leftImagePaddingBottom);
    }

    public int getLeftImagePaddingRight() {
        return leftImagePaddingRight;
    }

    public void setLeftImagePaddingRight(int leftImagePaddingRight) {
        this.leftImagePaddingRight = leftImagePaddingRight;
        setPadding(leftImageView, leftImagePadding, leftImagePaddingLeft, leftImagePaddingTop, leftImagePaddingRight, leftImagePaddingBottom);
    }

    public int getLeftImagePaddingBottom() {
        return leftImagePaddingBottom;
    }

    public void setLeftImagePaddingBottom(int leftImagePaddingBottom) {
        this.leftImagePaddingBottom = leftImagePaddingBottom;
        setPadding(leftImageView, leftImagePadding, leftImagePaddingLeft, leftImagePaddingTop, leftImagePaddingRight, leftImagePaddingBottom);
    }

    public int getLeftTextBackground() {
        return leftTextBackground;
    }

    public void setLeftTextBackground(int leftTextBackground) {
        this.leftTextBackground = leftTextBackground;
        leftTextView.setBackgroundResource(leftTextBackground);
    }

    public String getLeftText() {
        return leftText;
    }

    public void setLeftText(String leftText) {
        this.leftText = leftText;
        leftTextView.setText(leftText);
    }

    public float getLeftTextSize() {
        return leftTextSize;
    }

    public void setLeftTextSize(float leftTextSize) {
        this.leftTextSize = leftTextSize;
        leftTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize);
    }

    public int getLeftTextColor() {
        return leftTextColor;
    }

    public void setLeftTextColor(int leftTextColor) {
        this.leftTextColor = leftTextColor;
        leftTextView.setTextColor(leftTextColor);
    }

    public int getLeftTextGravity() {
        return leftTextGravity;
    }

    public void setLeftTextGravity(int leftTextGravity) {
        this.leftTextGravity = leftTextGravity;
        leftTextView.setGravity(leftTextGravity);
    }

    public float getLeftTextWeight() {
        return leftTextWeight;
    }

    public void setLeftTextWeight(float leftTextWeight) {
        this.leftTextWeight = leftTextWeight;
        setWeight(leftTextView, leftTextWeight);
    }

    public int getLeftTextMargin() {
        return leftTextMargin;
    }

    public void setLeftTextMargin(int leftTextMargin) {
        this.leftTextMargin = leftTextMargin;
        setMargin(leftTextView, leftTextMargin, leftTextMarginLeft, leftTextMarginTop, leftTextMarginRight, leftTextMarginBottom);
    }

    public int getLeftTextMarginLeft() {
        return leftTextMarginLeft;
    }

    public void setLeftTextMarginLeft(int leftTextMarginLeft) {
        this.leftTextMarginLeft = leftTextMarginLeft;
        setMargin(leftTextView, leftTextMargin, leftTextMarginLeft, leftTextMarginTop, leftTextMarginRight, leftTextMarginBottom);
    }

    public int getLeftTextMarginTop() {
        return leftTextMarginTop;
    }

    public void setLeftTextMarginTop(int leftTextMarginTop) {
        this.leftTextMarginTop = leftTextMarginTop;
        setMargin(leftTextView, leftTextMargin, leftTextMarginLeft, leftTextMarginTop, leftTextMarginRight, leftTextMarginBottom);
    }

    public int getLeftTextMarginRight() {
        return leftTextMarginRight;
    }

    public void setLeftTextMarginRight(int leftTextMarginRight) {
        this.leftTextMarginRight = leftTextMarginRight;
        setMargin(leftTextView, leftTextMargin, leftTextMarginLeft, leftTextMarginTop, leftTextMarginRight, leftTextMarginBottom);
    }

    public int getLeftTextMarginBottom() {
        return leftTextMarginBottom;
    }

    public void setLeftTextMarginBottom(int leftTextMarginBottom) {
        this.leftTextMarginBottom = leftTextMarginBottom;
        setMargin(leftTextView, leftTextMargin, leftTextMarginLeft, leftTextMarginTop, leftTextMarginRight, leftTextMarginBottom);
    }

    public int getLeftTextPadding() {
        return leftTextPadding;
    }

    public void setLeftTextPadding(int leftTextPadding) {
        this.leftTextPadding = leftTextPadding;
        setPadding(leftTextView, leftTextPadding, leftTextPaddingLeft, leftTextPaddingTop, leftTextPaddingRight, leftTextPaddingBottom);
    }

    public int getLeftTextPaddingLeft() {
        return leftTextPaddingLeft;
    }

    public void setLeftTextPaddingLeft(int leftTextPaddingLeft) {
        this.leftTextPaddingLeft = leftTextPaddingLeft;
        setPadding(leftTextView, leftTextPadding, leftTextPaddingLeft, leftTextPaddingTop, leftTextPaddingRight, leftTextPaddingBottom);
    }

    public int getLeftTextPaddingTop() {
        return leftTextPaddingTop;
    }

    public void setLeftTextPaddingTop(int leftTextPaddingTop) {
        this.leftTextPaddingTop = leftTextPaddingTop;
        setPadding(leftTextView, leftTextPadding, leftTextPaddingLeft, leftTextPaddingTop, leftTextPaddingRight, leftTextPaddingBottom);
    }

    public int getLeftTextPaddingRight() {
        return leftTextPaddingRight;
    }

    public void setLeftTextPaddingRight(int leftTextPaddingRight) {
        this.leftTextPaddingRight = leftTextPaddingRight;
        setPadding(leftTextView, leftTextPadding, leftTextPaddingLeft, leftTextPaddingTop, leftTextPaddingRight, leftTextPaddingBottom);
    }

    public int getLeftTextPaddingBottom() {
        return leftTextPaddingBottom;
    }

    public void setLeftTextPaddingBottom(int leftTextPaddingBottom) {
        this.leftTextPaddingBottom = leftTextPaddingBottom;
        setPadding(leftTextView, leftTextPadding, leftTextPaddingLeft, leftTextPaddingTop, leftTextPaddingRight, leftTextPaddingBottom);
    }

    public int getCenterTextBackground() {
        return centerTextBackground;
    }

    public void setCenterTextBackground(int centerTextBackground) {
        this.centerTextBackground = centerTextBackground;
        centerTextView.setBackgroundResource(centerTextBackground);
    }

    public String getCenterText() {
        return centerText;
    }

    public void setCenterText(String centerText) {
        this.centerText = centerText;
        centerTextView.setText(centerText);
    }

    public int getCenterTextSize() {
        return centerTextSize;
    }

    public void setCenterTextSize(int centerTextSize) {
        this.centerTextSize = centerTextSize;
        centerTextView.setTextSize(centerTextSize);
    }

    public int getCenterTextColor() {
        return centerTextColor;
    }

    public void setCenterTextColor(int centerTextColor) {
        this.centerTextColor = centerTextColor;
        centerTextView.setTextColor(centerTextColor);
    }

    public int getCenterTextGravity() {
        return centerTextGravity;
    }

    public void setCenterTextGravity(int centerTextGravity) {
        this.centerTextGravity = centerTextGravity;
        centerTextView.setGravity(centerTextGravity);
    }

    public float getCenterTextWeight() {
        return centerTextWeight;
    }

    public void setCenterTextWeight(float centerTextWeight) {
        this.centerTextWeight = centerTextWeight;
        setWeight(centerTextView, centerTextWeight);
    }

    public int getCenterTextMargin() {
        return centerTextMargin;
    }

    public void setCenterTextMargin(int centerTextMargin) {
        this.centerTextMargin = centerTextMargin;
        setMargin(centerTextView, centerTextMargin, centerTextMarginLeft, centerTextMarginTop, centerTextMarginRight, centerTextMarginBottom);
    }

    public int getCenterTextMarginLeft() {
        return centerTextMarginLeft;
    }

    public void setCenterTextMarginLeft(int centerTextMarginLeft) {
        this.centerTextMarginLeft = centerTextMarginLeft;
        setMargin(centerTextView, centerTextMargin, centerTextMarginLeft, centerTextMarginTop, centerTextMarginRight, centerTextMarginBottom);
    }

    public int getCenterTextMarginTop() {
        return centerTextMarginTop;
    }

    public void setCenterTextMarginTop(int centerTextMarginTop) {
        this.centerTextMarginTop = centerTextMarginTop;
        setMargin(centerTextView, centerTextMargin, centerTextMarginLeft, centerTextMarginTop, centerTextMarginRight, centerTextMarginBottom);
    }

    public int getCenterTextMarginRight() {
        return centerTextMarginRight;
    }

    public void setCenterTextMarginRight(int centerTextMarginRight) {
        this.centerTextMarginRight = centerTextMarginRight;
        setMargin(centerTextView, centerTextMargin, centerTextMarginLeft, centerTextMarginTop, centerTextMarginRight, centerTextMarginBottom);
    }

    public int getCenterTextMarginBottom() {
        return centerTextMarginBottom;
    }

    public void setCenterTextMarginBottom(int centerTextMarginBottom) {
        this.centerTextMarginBottom = centerTextMarginBottom;
        setMargin(centerTextView, centerTextMargin, centerTextMarginLeft, centerTextMarginTop, centerTextMarginRight, centerTextMarginBottom);
    }

    public int getCenterTextPadding() {
        return centerTextPadding;
    }

    public void setCenterTextPadding(int centerTextPadding) {
        this.centerTextPadding = centerTextPadding;
        setPadding(centerTextView, centerTextPadding, centerTextPaddingLeft, centerTextPaddingTop, centerTextPaddingRight, centerTextPaddingBottom);
    }

    public int getCenterTextPaddingLeft() {
        return centerTextPaddingLeft;
    }

    public void setCenterTextPaddingLeft(int centerTextPaddingLeft) {
        this.centerTextPaddingLeft = centerTextPaddingLeft;
        setPadding(centerTextView, centerTextPadding, centerTextPaddingLeft, centerTextPaddingTop, centerTextPaddingRight, centerTextPaddingBottom);
    }

    public int getCenterTextPaddingTop() {
        return centerTextPaddingTop;
    }

    public void setCenterTextPaddingTop(int centerTextPaddingTop) {
        this.centerTextPaddingTop = centerTextPaddingTop;
        setPadding(centerTextView, centerTextPadding, centerTextPaddingLeft, centerTextPaddingTop, centerTextPaddingRight, centerTextPaddingBottom);
    }

    public int getCenterTextPaddingRight() {
        return centerTextPaddingRight;
    }

    public void setCenterTextPaddingRight(int centerTextPaddingRight) {
        this.centerTextPaddingRight = centerTextPaddingRight;
        setPadding(centerTextView, centerTextPadding, centerTextPaddingLeft, centerTextPaddingTop, centerTextPaddingRight, centerTextPaddingBottom);
    }

    public int getCenterTextPaddingBottom() {
        return centerTextPaddingBottom;
    }

    public void setCenterTextPaddingBottom(int centerTextPaddingBottom) {
        this.centerTextPaddingBottom = centerTextPaddingBottom;
        setPadding(centerTextView, centerTextPadding, centerTextPaddingLeft, centerTextPaddingTop, centerTextPaddingRight, centerTextPaddingBottom);
    }

    public int getRightTextBackground() {
        return rightTextBackground;
    }

    public void setRightTextBackground(int rightTextBackground) {
        this.rightTextBackground = rightTextBackground;
        rightTextView.setBackgroundResource(rightTextBackground);
    }

    public String getRightText() {
        return rightText;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText;
        rightTextView.setText(rightText);
    }

    public int getRightTextSize() {
        return rightTextSize;
    }

    public void setRightTextSize(int rightTextSize) {
        this.rightTextSize = rightTextSize;
        rightTextView.setTextSize(TypedValue.COMPLEX_UNIT_IN, rightTextSize);
    }

    public int getRightTextColor() {
        return rightTextColor;
    }

    public void setRightTextColor(int rightTextColor) {
        this.rightTextColor = rightTextColor;
        rightTextView.setTextColor(rightTextColor);
    }

    public int getRightTextGravity() {
        return rightTextGravity;
    }

    public void setRightTextGravity(int rightTextGravity) {
        this.rightTextGravity = rightTextGravity;
        rightTextView.setGravity(rightTextGravity);
    }

    public float getRightTextWeight() {
        return rightTextWeight;
    }

    public void setRightTextWeight(float rightTextWeight) {
        this.rightTextWeight = rightTextWeight;
        setWeight(rightTextView, rightTextWeight);
    }

    public int getRightTextMargin() {
        return rightTextMargin;
    }

    public void setRightTextMargin(int rightTextMargin) {
        this.rightTextMargin = rightTextMargin;
        setMargin(rightTextView, rightTextMargin, rightTextMarginLeft, rightTextMarginTop, rightTextMarginRight, rightTextMarginBottom);
    }

    public int getRightTextMarginLeft() {
        return rightTextMarginLeft;
    }

    public void setRightTextMarginLeft(int rightTextMarginLeft) {
        this.rightTextMarginLeft = rightTextMarginLeft;
        setMargin(rightTextView, rightTextMargin, rightTextMarginLeft, rightTextMarginTop, rightTextMarginRight, rightTextMarginBottom);
    }

    public int getRightTextMarginTop() {
        return rightTextMarginTop;
    }

    public void setRightTextMarginTop(int rightTextMarginTop) {
        this.rightTextMarginTop = rightTextMarginTop;
        setMargin(rightTextView, rightTextMargin, rightTextMarginLeft, rightTextMarginTop, rightTextMarginRight, rightTextMarginBottom);
    }

    public int getRightTextMarginRight() {
        return rightTextMarginRight;
    }

    public void setRightTextMarginRight(int rightTextMarginRight) {
        this.rightTextMarginRight = rightTextMarginRight;
        setMargin(rightTextView, rightTextMargin, rightTextMarginLeft, rightTextMarginTop, rightTextMarginRight, rightTextMarginBottom);
    }

    public int getRightTextMarginBottom() {
        return rightTextMarginBottom;
    }

    public void setRightTextMarginBottom(int rightTextMarginBottom) {
        this.rightTextMarginBottom = rightTextMarginBottom;
        setMargin(rightTextView, rightTextMargin, rightTextMarginLeft, rightTextMarginTop, rightTextMarginRight, rightTextMarginBottom);
    }

    public int getRightTextPadding() {
        return rightTextPadding;
    }

    public void setRightTextPadding(int rightTextPadding) {
        this.rightTextPadding = rightTextPadding;
        setPadding(rightTextView, rightTextPadding, rightTextPaddingLeft, rightTextPaddingTop, rightTextPaddingRight, rightTextPaddingBottom);
    }

    public int getRightTextPaddingLeft() {
        return rightTextPaddingLeft;
    }

    public void setRightTextPaddingLeft(int rightTextPaddingLeft) {
        this.rightTextPaddingLeft = rightTextPaddingLeft;
        setPadding(rightTextView, rightTextPadding, rightTextPaddingLeft, rightTextPaddingTop, rightTextPaddingRight, rightTextPaddingBottom);
    }

    public int getRightTextPaddingTop() {
        return rightTextPaddingTop;
    }

    public void setRightTextPaddingTop(int rightTextPaddingTop) {
        this.rightTextPaddingTop = rightTextPaddingTop;
        setPadding(rightTextView, rightTextPadding, rightTextPaddingLeft, rightTextPaddingTop, rightTextPaddingRight, rightTextPaddingBottom);
    }

    public int getRightTextPaddingRight() {
        return rightTextPaddingRight;
    }

    public void setRightTextPaddingRight(int rightTextPaddingRight) {
        this.rightTextPaddingRight = rightTextPaddingRight;
        setPadding(rightTextView, rightTextPadding, rightTextPaddingLeft, rightTextPaddingTop, rightTextPaddingRight, rightTextPaddingBottom);
    }

    public int getRightTextPaddingBottom() {
        return rightTextPaddingBottom;
    }

    public void setRightTextPaddingBottom(int rightTextPaddingBottom) {
        this.rightTextPaddingBottom = rightTextPaddingBottom;
        setPadding(rightTextView, rightTextPadding, rightTextPaddingLeft, rightTextPaddingTop, rightTextPaddingRight, rightTextPaddingBottom);
    }

    public int getEditWidth() {
        return editWidth;
    }

    public void setEditWidth(int editWidth) {
        this.editWidth = editWidth;
        setParams(editView, editWidth, editHeight);
    }

    public int getEditHeight() {
        return editHeight;
    }

    public void setEditHeight(int editHeight) {
        this.editHeight = editHeight;
        setParams(editView, editWidth, editHeight);
    }

    public boolean isEditFocusable() {
        return editFocusable;
    }

    public void setEditFocusable(boolean editFocusable) {
        this.editFocusable = editFocusable;
        editView.setFocusable(editFocusable);
    }

    public int getEditHintTextColor() {
        return editHintTextColor;
    }

    public void setEditHintTextColor(int editHintTextColor) {
        this.editHintTextColor = editHintTextColor;
        editView.setHintTextColor(editHintTextColor);
    }

    public String getEditHintText() {
        return editHintText;
    }

    public void setEditHintText(String editHintText) {
        this.editHintText = editHintText;
        editView.setHint(editHintText);
    }

    public int getEditBackground() {
        return editBackground;
    }

    public void setEditBackground(int editBackground) {
        this.editBackground = editBackground;
        editView.setBackgroundResource(editBackground);
    }

    public boolean isEditSingleLine() {
        return editSingleLine;
    }

    public void setEditSingleLine(boolean editSingleLine) {
        this.editSingleLine = editSingleLine;
        editView.setSingleLine(editSingleLine);
    }

    public int getEditMaxLines() {
        return editMaxLines;
    }

    public void setEditMaxLines(int editMaxLines) {
        this.editMaxLines = editMaxLines;
        editView.setMaxLines(editMaxLines);
    }

    public int getEditMaxLength() {
        return editMaxLength;
    }

    public void setEditMaxLength(int editMaxLength) {
        this.editMaxLength = editMaxLength;
        editView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(editMaxLength)});
    }

    public String getEditDigits() {
        return editDigits;
    }

    public void setEditDigits(String editDigits) {
        this.editDigits = editDigits;
        editView.setKeyListener(DigitsKeyListener.getInstance(editDigits));
    }

    public TextUtils.TruncateAt getEditEllipsize() {
        return truncateAts[editEllipsize];
    }

    public void setEditEllipsize(TextUtils.TruncateAt truncateAt) {
        for (int i = 0; i < truncateAts.length; i++) {
            if (truncateAts[i] == truncateAt) {
                this.editEllipsize = i;
            }
        }
        editView.setEllipsize(truncateAt);
    }

    public int getEditInputType() {
        return editInputType;
    }

    public void setEditInputType(int editInputType) {
        this.editInputType = editInputType;
        editView.setInputType(inputTypes[editInputType]);
    }

    public float getEditWeight() {
        return editWeight;
    }

    public void setEditWeight(float editWeight) {
        this.editWeight = editWeight;
        setWeight(editView, editWeight);
    }

    public String getEditText() {
        return editText;
    }

    public void setEditText(String editText) {
        this.editText = editText;
        editView.setText(editText);
    }

    public int getEditTextSize() {
        return editTextSize;
    }

    public void setEditTextSize(int editTextSize) {
        this.editTextSize = editTextSize;
        editView.setTextSize(TypedValue.COMPLEX_UNIT_IN, editTextSize);
    }

    public int getEditTextColor() {
        return editTextColor;
    }

    public void setEditTextColor(int editTextColor) {
        this.editTextColor = editTextColor;
        editView.setTextColor(editTextColor);
    }

    public int getEditGravity() {
        return editGravity;
    }

    public void setEditGravity(int editGravity) {
        this.editGravity = editGravity;
        editView.setGravity(editGravity);
    }

    public int getEditMargin() {
        return editMargin;
    }

    public void setEditMargin(int editMargin) {
        this.editMargin = editMargin;
        setMargin(editView, editMargin, editMarginLeft, editMarginTop, editMarginRight, editMarginBottom);
    }

    public int getEditMarginLeft() {
        return editMarginLeft;
    }

    public void setEditMarginLeft(int editMarginLeft) {
        this.editMarginLeft = editMarginLeft;
        setMargin(editView, editMargin, editMarginLeft, editMarginTop, editMarginRight, editMarginBottom);
    }

    public int getEditMarginTop() {
        return editMarginTop;
    }

    public void setEditMarginTop(int editMarginTop) {
        this.editMarginTop = editMarginTop;
        setMargin(editView, editMargin, editMarginLeft, editMarginTop, editMarginRight, editMarginBottom);
    }

    public int getEditMarginRight() {
        return editMarginRight;
    }

    public void setEditMarginRight(int editMarginRight) {
        this.editMarginRight = editMarginRight;
        setMargin(editView, editMargin, editMarginLeft, editMarginTop, editMarginRight, editMarginBottom);
    }

    public int getEditMarginBottom() {
        return editMarginBottom;
    }

    public void setEditMarginBottom(int editMarginBottom) {
        this.editMarginBottom = editMarginBottom;
        setMargin(editView, editMargin, editMarginLeft, editMarginTop, editMarginRight, editMarginBottom);
    }

    public int getEditPadding() {
        return editPadding;
    }

    public void setEditPadding(int editPadding) {
        this.editPadding = editPadding;
        setPadding(editView, editPadding, editPaddingLeft, editPaddingTop, editPaddingRight, editPaddingBottom);
    }

    public int getEditPaddingLeft() {
        return editPaddingLeft;
    }

    public void setEditPaddingLeft(int editPaddingLeft) {
        this.editPaddingLeft = editPaddingLeft;
        setPadding(editView, editPadding, editPaddingLeft, editPaddingTop, editPaddingRight, editPaddingBottom);
    }

    public int getEditPaddingTop() {
        return editPaddingTop;
    }

    public void setEditPaddingTop(int editPaddingTop) {
        this.editPaddingTop = editPaddingTop;
        setPadding(editView, editPadding, editPaddingLeft, editPaddingTop, editPaddingRight, editPaddingBottom);
    }

    public int getEditPaddingRight() {
        return editPaddingRight;
    }

    public void setEditPaddingRight(int editPaddingRight) {
        this.editPaddingRight = editPaddingRight;
        setPadding(editView, editPadding, editPaddingLeft, editPaddingTop, editPaddingRight, editPaddingBottom);
    }

    public int getEditPaddingBottom() {
        return editPaddingBottom;
    }

    public void setEditPaddingBottom(int editPaddingBottom) {
        this.editPaddingBottom = editPaddingBottom;
        setPadding(editView, editPadding, editPaddingLeft, editPaddingTop, editPaddingRight, editPaddingBottom);
    }

    public int getRightImageSrc() {
        return rightImageSrc;
    }

    public void setRightImageSrc(int rightImageSrc) {
        this.rightImageSrc = rightImageSrc;
        rightImageView.setImageResource(rightImageSrc);
    }

    public int getRightImageBackground() {
        return rightImageBackground;
    }

    public void setRightImageBackground(int rightImageBackground) {
        this.rightImageBackground = rightImageBackground;
        rightImageView.setBackgroundResource(rightImageBackground);
    }

    public int getRightImageWidth() {
        return rightImageWidth;
    }

    public void setRightImageWidth(int rightImageWidth) {
        this.rightImageWidth = rightImageWidth;
        setParams(rightImageView, rightImageWidth, rightImageHeight);
    }

    public int getRightImageHeight() {
        return rightImageHeight;
    }

    public void setRightImageHeight(int rightImageHeight) {
        this.rightImageHeight = rightImageHeight;
        setParams(rightImageView, rightImageWidth, rightImageHeight);
    }

    public ImageView.ScaleType getRightImageScaleType() {
        return scaleTypes[rightImageScaleType];
    }

    public void setRightImageScaleType(ImageView.ScaleType scaleType) {
        for (int i = 0; i < scaleTypes.length; i++) {
            if (scaleTypes[i] == scaleType) {
                this.rightImageScaleType = i;
            }
        }
        rightImageView.setScaleType(scaleType);
    }

    public int getRightImageMargin() {
        return rightImageMargin;
    }

    public void setRightImageMargin(int rightImageMargin) {
        this.rightImageMargin = rightImageMargin;
        setMargin(rightImageView, rightImageMargin, rightImageMarginLeft, rightImageMarginTop, rightImageMarginRight, rightImageMarginBottom);
    }

    public int getRightImageMarginLeft() {
        return rightImageMarginLeft;
    }

    public void setRightImageMarginLeft(int rightImageMarginLeft) {
        this.rightImageMarginLeft = rightImageMarginLeft;
        setMargin(rightImageView, rightImageMargin, rightImageMarginLeft, rightImageMarginTop, rightImageMarginRight, rightImageMarginBottom);
    }

    public int getRightImageMarginTop() {
        return rightImageMarginTop;
    }

    public void setRightImageMarginTop(int rightImageMarginTop) {
        this.rightImageMarginTop = rightImageMarginTop;
        setMargin(rightImageView, rightImageMargin, rightImageMarginLeft, rightImageMarginTop, rightImageMarginRight, rightImageMarginBottom);
    }

    public int getRightImageMarginRight() {
        return rightImageMarginRight;
    }

    public void setRightImageMarginRight(int rightImageMarginRight) {
        this.rightImageMarginRight = rightImageMarginRight;
        setMargin(rightImageView, rightImageMargin, rightImageMarginLeft, rightImageMarginTop, rightImageMarginRight, rightImageMarginBottom);
    }

    public int getRightImageMarginBottom() {
        return rightImageMarginBottom;
    }

    public void setRightImageMarginBottom(int rightImageMarginBottom) {
        this.rightImageMarginBottom = rightImageMarginBottom;
        setMargin(rightImageView, rightImageMargin, rightImageMarginLeft, rightImageMarginTop, rightImageMarginRight, rightImageMarginBottom);
    }

    public int getRightImagePadding() {
        return rightImagePadding;
    }

    public void setRightImagePadding(int rightImagePadding) {
        this.rightImagePadding = rightImagePadding;
        setPadding(rightImageView, rightImagePadding, rightTextPaddingLeft, rightImagePaddingTop, rightTextPaddingRight, rightImagePaddingBottom);
    }

    public int getRightImagePaddingLeft() {
        return rightImagePaddingLeft;
    }

    public void setRightImagePaddingLeft(int rightImagePaddingLeft) {
        this.rightImagePaddingLeft = rightImagePaddingLeft;
        setPadding(rightImageView, rightImagePadding, rightTextPaddingLeft, rightImagePaddingTop, rightTextPaddingRight, rightImagePaddingBottom);
    }

    public int getRightImagePaddingTop() {
        return rightImagePaddingTop;
    }

    public void setRightImagePaddingTop(int rightImagePaddingTop) {
        this.rightImagePaddingTop = rightImagePaddingTop;
        setPadding(rightImageView, rightImagePadding, rightTextPaddingLeft, rightImagePaddingTop, rightTextPaddingRight, rightImagePaddingBottom);
    }

    public int getRightImagePaddingRight() {
        return rightImagePaddingRight;
    }

    public void setRightImagePaddingRight(int rightImagePaddingRight) {
        this.rightImagePaddingRight = rightImagePaddingRight;
        setPadding(rightImageView, rightImagePadding, rightTextPaddingLeft, rightImagePaddingTop, rightTextPaddingRight, rightImagePaddingBottom);
    }

    public int getRightImagePaddingBottom() {
        return rightImagePaddingBottom;
    }

    public void setRightImagePaddingBottom(int rightImagePaddingBottom) {
        this.rightImagePaddingBottom = rightImagePaddingBottom;
        setPadding(rightImageView, rightImagePadding, rightTextPaddingLeft, rightImagePaddingTop, rightTextPaddingRight, rightImagePaddingBottom);
    }

    public int getCenterImageSrc() {
        return centerImageSrc;
    }

    public void setCenterImageSrc(int centerImageSrc) {
        this.centerImageSrc = centerImageSrc;
        centerImageView.setImageResource(centerImageSrc);
    }

    public int getCenterImageBackground() {
        return centerImageBackground;
    }

    public void setCenterImageBackground(int centerImageBackground) {
        this.centerImageBackground = centerImageBackground;
        centerImageView.setBackgroundResource(centerImageBackground);
    }

    public int getCenterImageWidth() {
        return centerImageWidth;
    }

    public void setCenterImageWidth(int centerImageWidth) {
        this.centerImageWidth = centerImageWidth;
        setParams(centerImageView, centerImageWidth, centerImageHeight);
    }

    public int getCenterImageHeight() {
        return centerImageHeight;
    }

    public void setCenterImageHeight(int centerImageHeight) {
        this.centerImageHeight = centerImageHeight;
        setParams(centerImageView, centerImageWidth, centerImageHeight);
    }

    public ImageView.ScaleType getCenterImageScaleType() {
        return scaleTypes[centerImageScaleType];
    }

    public void setCenterImageScaleType(ImageView.ScaleType scaleType) {
        for (int i = 0; i < scaleTypes.length; i++) {
            if (scaleTypes[i] == scaleType) {
                this.centerImageScaleType = i;
            }
        }
        centerImageView.setScaleType(scaleType);
    }

    public int getCenterImageMargin() {
        return centerImageMargin;
    }

    public void setCenterImageMargin(int centerImageMargin) {
        this.centerImageMargin = centerImageMargin;
        setMargin(centerImageView, centerImageMargin, centerImageMarginLeft, centerImageMarginTop, centerImageMarginRight, centerImageMarginBottom);
    }

    public int getCenterImageMarginLeft() {
        return centerImageMarginLeft;
    }

    public void setCenterImageMarginLeft(int centerImageMarginLeft) {
        this.centerImageMarginLeft = centerImageMarginLeft;
        setMargin(centerImageView, centerImageMargin, centerImageMarginLeft, centerImageMarginTop, centerImageMarginRight, centerImageMarginBottom);
    }

    public int getCenterImageMarginTop() {
        return centerImageMarginTop;
    }

    public void setCenterImageMarginTop(int centerImageMarginTop) {
        this.centerImageMarginTop = centerImageMarginTop;
        setMargin(centerImageView, centerImageMargin, centerImageMarginLeft, centerImageMarginTop, centerImageMarginRight, centerImageMarginBottom);
    }

    public int getCenterImageMarginCenter() {
        return centerImageMarginRight;
    }

    public void setCenterImageMarginCenter(int centerImageMarginRight) {
        this.centerImageMarginRight = centerImageMarginRight;
        setMargin(centerImageView, centerImageMargin, centerImageMarginLeft, centerImageMarginTop, centerImageMarginRight, centerImageMarginBottom);
    }

    public int getCenterImageMarginBottom() {
        return centerImageMarginBottom;
    }

    public void setCenterImageMarginBottom(int centerImageMarginBottom) {
        this.centerImageMarginBottom = centerImageMarginBottom;
        setMargin(centerImageView, centerImageMargin, centerImageMarginLeft, centerImageMarginTop, centerImageMarginRight, centerImageMarginBottom);
    }

    public int getCenterImagePadding() {
        return centerImagePadding;
    }

    public void setCenterImagePadding(int centerImagePadding) {
        this.centerImagePadding = centerImagePadding;
        setPadding(centerImageView, centerImagePadding, centerTextPaddingLeft, centerImagePaddingTop, centerTextPaddingRight, centerImagePaddingBottom);
    }

    public int getCenterImagePaddingLeft() {
        return centerImagePaddingLeft;
    }

    public void setCenterImagePaddingLeft(int centerImagePaddingLeft) {
        this.centerImagePaddingLeft = centerImagePaddingLeft;
        setPadding(centerImageView, centerImagePadding, centerTextPaddingLeft, centerImagePaddingTop, centerTextPaddingRight, centerImagePaddingBottom);
    }

    public int getCenterImagePaddingTop() {
        return centerImagePaddingTop;
    }

    public void setCenterImagePaddingTop(int centerImagePaddingTop) {
        this.centerImagePaddingTop = centerImagePaddingTop;
        setPadding(centerImageView, centerImagePadding, centerTextPaddingLeft, centerImagePaddingTop, centerTextPaddingRight, centerImagePaddingBottom);
    }

    public int getCenterImagePaddingRight() {
        return centerImagePaddingRight;
    }

    public void setCenterImagePaddingRight(int centerImagePaddingRight) {
        this.centerImagePaddingRight = centerImagePaddingRight;
        setPadding(centerImageView, centerImagePadding, centerTextPaddingLeft, centerImagePaddingTop, centerTextPaddingRight, centerImagePaddingBottom);
    }

    public int getCenterImagePaddingBottom() {
        return centerImagePaddingBottom;
    }

    public void setCenterImagePaddingBottom(int centerImagePaddingBottom) {
        this.centerImagePaddingBottom = centerImagePaddingBottom;
        setPadding(centerImageView, centerImagePadding, centerTextPaddingLeft, centerImagePaddingTop, centerTextPaddingRight, centerImagePaddingBottom);
    }


}