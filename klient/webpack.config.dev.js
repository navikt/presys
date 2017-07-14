"use strict";

const webpack = require('webpack');
const path = require('path');

const APP_DIR = path.resolve(__dirname, 'src/client/app');
const IMG_DIR = path.resolve(__dirname, 'src/client/images');
const STYLE_DIR = path.resolve(__dirname, 'src/client/styles');
const CORE_DIR = path.resolve(__dirname, 'node_modules/nav-frontend-core');

const ExtractTextPlugin = require('extract-text-webpack-plugin');

const config = {
	devtool : 'inline-source-map',
	entry : [ 
	    'webpack-dev-server/client?http://localhost:9000',
		'webpack/hot/only-dev-server', 
		'babel-polyfill',
		APP_DIR + '/index.jsx' 
	],
	output : {
		path : path.join(__dirname, 'src/client/public'),
		filename : 'bundle.js',
		publicPath : '/presys/public/'
	},
	module : {
		rules : [{
			test : /\.jsx?$/,
			enforce : "pre",
			loader : 'eslint-loader',
			include : APP_DIR,
			options : {
				failOnWarning : false,
				failOnError : true,
				configFile : './.eslintrc.dev.js',
				fix : true,
			},
			exclude : /node_modules/
		},
		{
			test : /\.jsx?$/,
			use : [	'react-hot-loader', 'babel-loader?presets[]=es2015,presets[]=es2016,presets[]=es2017,presets[]=react' ],
			include : APP_DIR,
		},
		{
			test : /\.less?$/,
			use : ExtractTextPlugin.extract({
				fallback : 'style-loader',
				use : [ {
					loader : 'css-loader',
					options : {
						importLoaders : 1,
						modules : true,
						localIdentName : '[name]_[local]_[hash:base64:5]'
					},
				}, {
				 loader : 'less-loader',
				 					options : {
				 					modules : true,
                 						localIdentName : '[name]_[local]_[hash:base64:5]'
                 					}}],
			}),
			include : [APP_DIR, STYLE_DIR, CORE_DIR]
		}, {
			test : /\.(jpg|png|svg)$/,
			loader : 'file-loader',
			options : {
				name : '[name]_[hash].[ext]'
			},
			include : IMG_DIR
		}]
	},

	plugins : [ 
       new ExtractTextPlugin("style.css"),
	   new webpack.HotModuleReplacementPlugin(),
	   new webpack.DefinePlugin({
	       'process.env.NODE_ENV' : JSON.stringify(process.env.NODE_ENV)
	   }), 
	],

	devServer : {
		historyApiFallback : true
	},

	resolve : {
		alias : {
			styles: STYLE_DIR,
			images: IMG_DIR,
			messages: path.resolve(__dirname, 'src/client/messages'),
			testHelpers: path.resolve(__dirname, 'src/client/test-helpers'),
			actions: APP_DIR + '/actions',
			components: APP_DIR + '/components',
			elements: APP_DIR + '/components/elements',
			constants: APP_DIR + '/constants',
			containers: APP_DIR + '/containers',
			reducers: APP_DIR + '/reducers',
			services: APP_DIR + '/services',
			helpers: APP_DIR + '/helpers',
			ducks: APP_DIR + '/ducks',
		},
		extensions : [ '.json', '.js', '.jsx' ]
	},

	externals : {
		'cheerio' : 'window',
		'react/addons' : 'react',
		'react/lib/ExecutionEnvironment' : 'react',
		'react/lib/ReactContext' : 'react',
	},
};
module.exports = config;
