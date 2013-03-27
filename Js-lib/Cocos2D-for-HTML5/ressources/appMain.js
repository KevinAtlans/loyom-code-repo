var Wars = cc.Layer.extend({
    ctor:function () {
        cc.associateWithNative( this, cc.Layer );
    },
    init:function(){
        var selfPointer = this;
        this._super();

        var logo = cc.Sprite.create(desk_src);
        logo.setAnchorPoint(cc.p(0,0));
        logo.setPosition(0,300);
        this.addChild(logo,100,100);
        return true;
    }
});

var WarsScene = cc.Scene.extend({
    onEnter:function () {
        this._super();
        var layer = new Wars();
        layer.init();
        this.addChild(layer);
    }
});
