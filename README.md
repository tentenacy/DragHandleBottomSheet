# DragHandleBottomSheet

![](https://jitpack.io/v/tentenacy/DragHandleBottomSheet.svg)

When scrolling within Bottom Sheet Dialog(BSD), unexpected behavior occurs when scrolling behavior is implemented using ScrollView or NestedScrollView. This library helps to avoid disrupting the basic behavior of scroll views in the dialog by dragging BSD only through the drag handle specified by the user.

# Preview

<p align="center">
  <img src="https://github.com/user-attachments/assets/5fbf52a9-41f1-4933-a5f7-dea1524a185f">
  <img height="744", src="https://github.com/user-attachments/assets/37b696b4-6ed9-4bd0-a437-36949f364934">
</p>

# Release

**settings.gradle**

```groovy
dependencies {
    implementation 'com.github.tentenacy:DragHandleBottomSheet:1.0.0'
}
```

**build.gradle(app)**

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
	}
}
```

# Usage

**In onViewCreated of your BottomSheetDialogFragment**

```kotlin
makeDraggableByHandle(
    dragHandle = view,              //(required)specifies the view that you want to drag
    scrollVerticalRatio = 0.45f,    //(optional)sets the critical percentage at which the BSD disappears or expands
    animatorDuration = 300L,        //(optional)sets the time (ms) of the animation to be executed
                                    //          when the height of the BSD is greater than the scrollVerticalRatio and expanded
                                    	
    interpolatorFactor = 2f,        //(optional)sets the factor of DecelerateInterpolator
)
```

# Example

For full example, please refer to the `sample` app.

Also you can browse the issue labeled as question [here](https://github.com/tentenacy/DragHandleBottomSheet/issues)

# License

Apache 2.0 License
