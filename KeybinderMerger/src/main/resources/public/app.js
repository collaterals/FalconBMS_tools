const bms = {
    data() {
        return {
            filePath1 : '',
            filePath2 : ''
        }
    },
    methods: {
        loadKeyBinding(filePath,callback) {
            console.log('/keyBinding/' + encodeURIComponent(filePath));
            fetch('/keyBinding/' + encodeURIComponent(filePath))
                .then(response => callback(response))
        },
        loadKeyBindings() {
            console.log("hello")
            this.loadKeyBinding(this.filePath1,function (keyBinding){
                console.log(keyBinding);
            })
        }
    }
}

Vue.createApp(bms).mount('#app');
