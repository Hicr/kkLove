Page({
    onLoad: function(options) {
        console.log("my页面创建时执行")
      },
      onShow: function() {
        console.log("my页面出现在前台时执行")
      },
      onReady: function() {
        console.log("my页面首次渲染完毕时执行")
      },
      onHide: function() {
        console.log("my页面从前台变为后台时执行")
      },
      onUnload: function() {
        console.log("my页面销毁时执行")
      },
      onPullDownRefresh: function() {
        console.log("my触发下拉刷新时执行")
      },
      onReachBottom: function() {
        console.log("my页面触底时执行")
      },
      onShareAppMessage: function () {
        console.log("my页面被用户分享时执行")
      },
      onPageScroll: function() {
        console.log("my页面滚动时执行")
      },
      onResize: function() {
        console.log("my页面尺寸变化时执行")
      },
      onTabItemTap(item) {
        // tab 点击时执行
        console.log(item.index)
        console.log(item.pagePath)
        console.log(item.text)
      },
});