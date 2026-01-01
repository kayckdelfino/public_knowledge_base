// For a detailed explanation regarding each configuration property, visit:
// https://jestjs.io/docs/en/configuration.html

module.exports = {
  collectCoverage: false,
  verbose: true,
  collectCoverageFrom: [
    '../**/*.js',
    "**/*.js",
    "!**/node_modules/**",
    "!**/coverage/**",
    "!**/tests/**",
    "!**/*.config.js"
  ],
  coverageDirectory: "./coverage",
  coverageReporters: ["json", "html", "text", "lcov"],
  moduleDirectories: [
    "node_modules",
    'src'
  ],
  moduleFileExtensions: [
    "js",
    "json"
  ],
  moduleNameMapper: {
    "@root/(.*)": "<rootDir>/../$1",
  },
  restoreMocks: false,
  rootDir: '../',
  roots: [
    "<rootDir>/src",
    "<rootDir>/tests"
  ]
};