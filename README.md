# GangedRecyclerview

#### 演示效果

1. 左侧联动右侧：
   点击左侧列表的某一项，背景变色，同时右侧列表中对应的分类滚动到顶部
2. 右侧列表悬停：
   右侧列表滑动的时候相应的标题栏需要在顶部悬停
3. 标题栏可点击
4. 右侧联动左侧：
   滚动右侧列表，监听滚动的位置，左侧列表需要同步选中相应的列表

<video width="540" height="1170" controls>     <source src="docs/device-2022-02-04-190625.mp4" type="video/mp4"> </video>

#### 接入文档

**Step 1.** Add the JitPack repository to your build file

```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

**Step 2.** Add the dependency

```groovy
implementation 'com.github.wustor:GangedRecyclerview:latest-version'
```

**Step 3.** 启动GangedRvActivity

```kotlin
val intent = Intent(this, GangedRvActivity::class.java)
//获取SortBean数据，具体可参见Demo
val data = DataUtil.getData(this, path)
val bundle = Bundle()
bundle.putSerializable(IIntent.DATA_TAG, data)
intent.putExtras(bundle)
startActivity(intent)
```