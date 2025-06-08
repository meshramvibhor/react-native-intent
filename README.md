# react-native-intent-handler

A React Native library that provides easy access to Android Intent data in your React Native application. This library allows you to read intent data on the React side without writing custom native bridges.

## Features

- Access intent extras (key-value pairs)
- Get complete intent data including:
  - Action
  - Data URI
  - MIME type
  - Categories
  - Extras

## Installation

```sh
npm install react-native-intent-handler
```

## Usage

### Get Intent Extras
```js
import { getIntentExtras } from 'react-native-intent-handler';

// Get only the extras from the intent
const extras = getIntentExtras();
console.log('Intent Extras:', extras);
// Returns: { [key: string]: string }
```

### Get Complete Intent Data
```js
import { getIntentData } from 'react-native-intent-handler';

// Get all intent data including action, data, type, categories, and extras
const intentData = getIntentData();
console.log('Intent Action:', intentData.action);
console.log('Intent Data:', intentData.data);
console.log('Intent Type:', intentData.type);
console.log('Intent Categories:', intentData.categories);
console.log('Intent Extras:', intentData.extras);

// Returns:
// {
//   action: string;      // e.g., "android.intent.action.VIEW"
//   data: string | null; // e.g., "content://..."
//   type: string | null; // e.g., "text/plain"
//   categories: string[]; // e.g., ["android.intent.category.DEFAULT"]
//   extras: { [key: string]: string }; // Additional data passed with the intent
// }
```

## Requirements

- React Native >= 0.70.0
- Android API Level >= 24 (Android 7.0)

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
