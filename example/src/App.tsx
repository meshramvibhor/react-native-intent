import { Text, View, StyleSheet } from 'react-native';
import { multiply, getIntentExtras } from 'react-native-intent-extras';

const result = multiply(3, 7);

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
      <Text>Intent Extras: {JSON.stringify(getIntentExtras('name'))}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
