//本地后端api访问ip + port，生成环境应替换成生产域名！
const baseApi = "http://localhost:8081";
 
//封装get request请求
export const getRequest = (url)=>{
    return new Promise((resolve, reject) => {
        wx.request({
            url: baseApi + url,
            method: "get",
            header: {
                //添加请求头
                "Authorization": wx.getStorageSync('userToken') || [] 
            },
            success(result){
                resolve(result);
            },
            fail(err){
                reject(err);
            }
        })
    })
}
//封装post request请求
export const postRequest = (url, data)=>{
    return new Promise((resolve, reject) => {
        wx.request({
            url: baseApi + url,
            method: "post",
            data: data,
            header: {
                //添加请求头
                "Authorization": wx.getStorageSync('userToken') || []
            },
            success(result){
                resolve(result);
            },
            fail(err){
                reject(err);
            }
        })
    })
}
 