const app = getApp()

Page({

  data: {
    
  },

  onLoad: function (params) {

  },

  log:function(){
    wx.navigateTo({
      url: '../logs/logs',
    })
  },

  // 登录  
  doLogin: function (e) {
    //console.log(e.detail.errMsg)
    //console.log(e.detail.userInfo)
    //console.log(e.detail.rawData)

    //获取凭证
    wx.login({
      success: function(res) {
        //console.log(res)
        // 获取登录的临时凭证
        var code = res.code;
        // 调用后端，获取微信的session_key, secret
        wx.request({
          url: "http://192.168.2.100:8080/wxlogin?code=" + code,
          method: "POST",
          success: function(result) {
            console.log(result);
            //保存用户信息到本地缓存，可以用作小程序端的拦截器
            wx.setStorageSync("userInfo",e.detail.userInfo);
            wx.navigateTo({
              url: '../logs/logs',
            })
          }
        })
      }
    })
  }
  
})