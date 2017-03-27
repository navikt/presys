export default function replaceNorwegianCharacters(str) {
  let result = str.split('æ').join('ae');
  result = result.split('ø').join('oe');
  return result.split('å').join('aa');
}
