var webpack = require('webpack');
var WebpackDevServer = require('webpack-dev-server');
var config = require('./webpack.config.dev');

var options = {
	contentBase : "src/client",
	proxy : {
		"/api/**" : {
			target : "http://localhost:8080",
			secure : false
		}
	},
	publicPath : config.output.publicPath,
	hot : true,
	noInfo : true,
	historyApiFallback : false,
	stats : {
		colors : true
	}
};

var wds = new WebpackDevServer(webpack(config), options);

wds.listen(9000, 'localhost', function(err) {
	if (err) {
		return console.log(err); //NOSONAR
	}

	console.log('Listening at http://localhost:9000/');
});
