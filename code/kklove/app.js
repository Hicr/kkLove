import { postRequest,getRequest } from "./util/request.js"
import { api } from "./util/api.js"

App({

  onLaunch: function (){
    wx.login({
      success: res => {
        if(res.code) {
          console.log("获取到用户code:"+res.code)
          getRequest(api.loginApi+"?code="+res.code).then(
            result => {
              if(result.statusCode === 200){
                console.log("获取到openid")
                console.log(result)
              }else{
                console.log("登陆用户信息获取失败，请管理员检查")
                console.log(result)
              }
            }
          )
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
