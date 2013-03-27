var wizard = function(canvasContext,name){
	this.name = name;
	this.ctx = canvasContext;
	this.walkLeft = function(initX,subtrahend){
		var ctx = this.ctx;
		var img = new Image();
		img.src="Resources/images/Wizard/walk-left.png";
        var index = 0;
        img.onload=function(){
            setInterval(function(){
        	    if(index>2){
                    index=0;
                }else{
                    index++;
                }
                initX -= subtrahend;
                ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height);
                ctx.drawImage(img,index * 80,0,80,75,initX,0,80,75);
            },210);
        }
	}

	this.walkRight = function(initX,addend){
		var ctx = this.ctx;
		var img = new Image();
		img.src="Resources/images/Wizard/walk-right.png";
        var index = 0;
        img.onload=function(){
            setInterval(function(){
        	    if(index>2){
                    index=0;
                }else{
                    index++;
                }
                initX += addend;
                ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height);
                ctx.drawImage(img,index * 80,0,80,75,initX,0,80,75);
            },210);
        }
	}

    this.weaponSwingLeft = function(x,y){
        var ctx = this.ctx;
        var img = new Image();
        img.src="Resources/images/Wizard/weaponSwingLeft.png";
        var index = 0;
        img.onload=function(){
            setInterval(function(){
                if(index>1){
                    index=0;
                }else{
                    index++;
                }
                ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height);
                ctx.drawImage(img,index * 67,0,67,126,x,y,67,126);
            },200);
        }
    }

    this.weaponSwingRight = function(x,y){
        var ctx = this.ctx;
        var img = new Image();
        img.src="Resources/images/Wizard/weaponSwingRight.png";
        var index = 0;
        img.onload=function(){
            setInterval(function(){
                if(index>1){
                    index=0;
                }else{
                    index++;
                }
                ctx.clearRect(0, 0, ctx.canvas.width, ctx.canvas.height);
                ctx.drawImage(img,index * 67,0,67,126,x,y,67,126);
            },200);
        }
    }
}