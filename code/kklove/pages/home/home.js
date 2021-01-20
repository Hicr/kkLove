const app = getApp();

Page({
 data: {
  name: '张三',
  now: app.globalData.now
 },
 buttonHandler(event) {
  this.setData({
   name: '李四'
   },function(){
    wx.showToast({
     title: '操作完成',
     duration: 700})
    });
 },
 handleClick(event){
   console.log('1')
 }
});
