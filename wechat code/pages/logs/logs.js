Page({
  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  onLoad() {
    // 查看是否授权
    var userInfo= wx.getStorageSync("userInfo");
    console.log("userInfo :"+userInfo);
  },
  bindGetUserInfo(e) {
    console.log(e.detail.userInfo)
  }
})