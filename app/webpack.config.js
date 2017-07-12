var path = require('path')
var webpack = require('webpack')
var fs = require('fs')

const vendor = { vendor: ['vue', 'vuex', 'axios', 'handsontable'] }
const entries = fs.readdirSync('./src/main/js')
                  .filter(a => /\.js$/.test(a))
                  .reduce((acc, x) => {
                    acc[x.slice(0, -3)] = './src/main/js/' + x
                    return acc
                  }, vendor)

module.exports = {
  entry: entries,
  output: {
    path: path.resolve(__dirname, './build/classes/main/static/assets'),
    publicPath: process.env.NODE_ENV === 'production' ? '/assets/' : '//localhost:8888/assets/',
    filename: '[name].js'
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          loaders: {
            sass: 'vue-style-loader!css-loader!sass-loader?indentedSyntax'
          }
          // other vue-loader options go here
        }
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/
      },
      {
        test: /\.(png|jpg|gif|svg)$/,
        loader: 'file-loader',
        options: {
          name: '[name].[ext]?[hash]'
        }
      },
      {
        test: /\.css$/,
        loader: 'style-loader!css-loader'
      },
      {
        test: /\.sass$/,
        loader: 'style-loader!css-loader!sass-loader?indentedSyntax'
      },
      {
        test: /\.(otf|eot|svg|ttf|woff|woff2)$/,
//        loader: 'url-loader'
        loader: 'file-loader',
        options: {
          name: '[name].[ext]?[hash]'
        }
      }
    ]
  },
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js'
    }
  },
  devServer: {
    historyApiFallback: true,
    noInfo: true,
    contentBase: path.join(__dirname, "./bin/static"),
    port: 8888,
    headers: {
      'Access-Control-Allow-Origin': '*'
    }
  },
  performance: {
    hints: false
  },
  devtool: '#eval-source-map'
}

if (process.env.NODE_ENV === 'production') {
  module.exports.devtool = '#source-map'
  // http://vue-loader.vuejs.org/en/workflow/production.html
  module.exports.plugins = (module.exports.plugins || []).concat([
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: '"production"'
      }
    }),
    new webpack.optimize.UglifyJsPlugin({
      sourceMap: true,
      compress: {
        warnings: false
      }
    }),
    new webpack.LoaderOptionsPlugin({
      minimize: true
    }),
    new webpack.optimize.CommonsChunkPlugin({
      name: "vendor",
      minChunks: Infinity
    })
  ])
}
