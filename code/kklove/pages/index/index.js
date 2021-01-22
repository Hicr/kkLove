Page({
    data: {
        current: 'home'
    },

    handleChange ({ detail }) {
        console.log(detail.key)
        this.setData({
            current: detail.key
        });
    }
});
