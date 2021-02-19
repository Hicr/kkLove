import { postRequest } from "./util/request.js"
import { api } from "./util/api.js"

App({

  onLaunch: function (){
    wx.login({
      success: res => {
        if(res.code) {
          wx.request({
            url: 'http://localhost:8081/wx/login',
            data:{
              code: res.code
            },
            success: function(res){
              if(res.statusCode === 200){
                console.log(res.data.sessionId)//服务器回包内容
              }
            }
          })
        }else{
          console.log('获取用户登录状态失败！'+ res.errMsg)
        }
      }
    })
  },
  globalData: {
    now: (new Date()).toLocaleString()
    }
});
