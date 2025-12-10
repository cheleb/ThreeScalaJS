pushd example/client
npm run build
popd
cp -rf example/client/img docs/_assets/demo/img
cp -rf example/client/css docs/_assets/demo/css
cp -rf example/client/res docs/_assets/demo/res
cp -rf example/client/sounds docs/_assets/demo/sounds
cp -rf example/client/fonts docs/_assets/demo/fonts
export VERSION=`git describe --tags --abbrev=0 | sed "s/v//"`
echo "Documentation version: $VERSION"
sbt makeSite