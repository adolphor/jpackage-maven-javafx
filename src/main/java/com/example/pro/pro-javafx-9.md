
# 总结

## 组件

### 图片：Image
```
Image image = new Image ("http://projavafx.com/images/earthrise.jpg");
ImageView imageView = new ImageView(image);
```

### 文本：Text
```
Text textRef = new Text(message);
```

## 分组：Group
可以裁切显示区域，参见范例 `com.example.pro.chapter01.listing11.HelloEarthRiseMain.java`。 


## 布局


## 动画

### 滚动显示文字
参见范例 `com.example.pro.chapter01.listing11.HelloEarthRiseMain.java`。
```
TranslateTransition transTransition = new TranslateTransition(new Duration(75000), textRef);
transTransition.setToY(-820);
transTransition.setInterpolator(Interpolator.LINEAR);
transTransition.setCycleCount(Timeline.INDEFINITE);
...code omitted...
// Start the text animation
transTransition.play();
```
可以将文字从

This TranslateTransition instance translates the Text node referenced by the textRef variable 
from its original Y position of 100 pixels to a Y position of –820 pixels, over a duration of 
75 seconds. 


## 事件绑定：binding















